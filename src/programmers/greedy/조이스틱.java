package programmers.greedy;

public class 조이스틱 {

    public static void main(String[] args) {
        Solution_조이스틱 s = new Solution_조이스틱();
        s.solution("BBAABB");
    }
}

/*
-> 알파벳 선택 최적, x-'A', 'Z'-x+1 의 min
-> 좌우 방향 선택 최적,
 */

class Solution_조이스틱{
    public int solution(String name) {
        int answer = 0;
        int move = 0;
        int sum = 0;
        int curIdx = 0;

        int tgtCnt = 0;
        int doneCnt = 0;

        boolean[] visited = new boolean[name.length()];

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') tgtCnt++;
        }

        while (true) {
            int charVal = Math.min(name.charAt(curIdx) - 'A', 'Z' - name.charAt(curIdx) + 1);
            if (charVal != 0) {
                visited[curIdx] = true;
                doneCnt++;

                if(doneCnt == tgtCnt) break;

                sum += charVal;

                int right = curIdx, left = curIdx;
                // 정방향, 역방향 중 최소 move를 가지는 다음 idx

                if (right < name.length()) {
                    right++;
                }
                left--;
                if (left < 0) left = name.length() - 1;

                if (name.charAt(right) != 'A' && visited[right]) {
                    move += (Math.abs(right - curIdx));
                    curIdx = right;
                    break;
                }
                if (name.charAt(left) != 'A' && visited[left]) {
                    move += (left > curIdx ? curIdx + name.length() - left : curIdx - left);
                    curIdx = left;
                    break;
                }
            }
        }
        return 0;
    }
}

