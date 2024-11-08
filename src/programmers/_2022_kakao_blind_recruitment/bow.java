package programmers._2022_kakao_blind_recruitment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class bow {
    public static void main(String[] args) {
        Solution_bow s = new Solution_bow();

        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};

        s.solution(10, info);
    }
}

class Solution_bow {
    int maxPointGap = -1;
    int[] answer = new int[11];
    int minIdx = 0;
    int minIdxCnt = 0;

    public int[] solution(int n, int[] info) {
        /*
        n=10 / info=11이므로 그리디로?
        - 무조건 info보다 점수를 크게 가져가거나 아예 안맞춰야함
        - 사용해야하는 화살 대비 점수 계산 후 n개 선택에 대한 조합별 점수차 비교

        - 동일 gap인 경우 낮은 점수를 더 많이 맞춘 케이스 출력***
         */

        for (int i = 1; i <= 10; i++) {
            this.getCombinations(info, i, n, 0, new ArrayList<>());
        }

        if (maxPointGap <= 0) {
            answer = new int[]{-1};
        }

        return answer;
    }

    //todo: chance만큼 winningPlan합이 되는 size개의 조합 확인
    public void getCombinations(int[] info, int size, int chance, int index, List<Integer> picked) {

        if (picked.size() == size) {

            boolean containZero = false;
            // 0점은 apc보다 더 많이 쏘지 않아도 되므로 sum에서 제외
            int sum = picked.stream().filter(idx -> idx != 10).mapToInt(idx -> info[idx] + 1).sum();

            if (picked.contains(10)) {
                containZero = true;
            }

            if (sum == chance || (sum < chance && containZero)) {
                // 점수차 비교
                int apcPoint = IntStream.range(0, 10).filter(idx -> !picked.contains(idx)).filter(idx -> info[idx] > 0).map(idx -> 10 - idx).sum();
                int pointGap = picked.stream().mapToInt(idx -> 10 - idx).sum() - apcPoint;

                if (maxPointGap < pointGap) {
                    maxPointGap = pointGap;
                    answer = this.getAnswerArr(info, picked, containZero, chance - sum);
                } else if (maxPointGap == pointGap) {
                    //todo: 낮은점수 더 많이 맞춘 케이스로 asnwer
                    int curMinIdx = picked.get(picked.size() - 1);
                    int curMinCnt = containZero ? (chance - sum) : info[curMinIdx] + 1;

                    if (minIdxCnt < curMinIdx || (minIdxCnt == curMinCnt && minIdxCnt < curMinCnt)) {
                        answer = this.getAnswerArr(info, picked, containZero, chance - sum);
                    }
                }
            }
        }

        // 배열 범위를 벗어나면 종료
        if (index == info.length || size == picked.size()) {
            return;
        }

        // 현재 숫자를 선택하는 경우
        picked.add(index);
        getCombinations(info, size, chance, index + 1, picked);

        // 현재 숫자를 선택하지 않는 경우
        picked.remove(picked.size() - 1);
        getCombinations(info, size, chance, index + 1, picked);
    }

    public int[] getAnswerArr(int[] info, List<Integer> picked, boolean containZero, int zeroCnt) {
        int[] newAnswer = new int[info.length];

        for (int pickedIdx : picked) {
            if (containZero && pickedIdx == 10) {
                newAnswer[pickedIdx] = zeroCnt;
            } else {
                newAnswer[pickedIdx] = info[pickedIdx] + 1;
            }
        }
        for (int i = 10; i >= 0; i--) {
            if (newAnswer[i] > 0) {
                minIdx = i;
                minIdxCnt = newAnswer[i];
                break;
            }
        }

        return newAnswer;
    }
}