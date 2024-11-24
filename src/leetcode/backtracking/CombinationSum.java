package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        int target = 7;

        List<Integer> candidate = new ArrayList<>();
        List<List<Integer>> answerList = new ArrayList<>();

        // nums 배열을 오름차순 정렬해서 효율성 향상
        getCombination(nums, target, 0, answerList, candidate);

        System.out.println(answerList);
    }

    public static void getCombination(int[] nums, int target, int startIndex, List<List<Integer>> answerList, List<Integer> candidate) {
        // 기저 조건: target이 0이 되면 현재 조합이 유효함
        if (target == 0) {
            answerList.add(new ArrayList<>(candidate));
            return;
        }

        // 주어진 숫자들로 반복하면서 조합 생성
        for (int i = startIndex; i < nums.length; i++) { // 여기서 startIdx를 선택 i와 동일하게 줌으로써 동일 숫자 선택 가능하게함

            // 숫자를 선택한 후 target이 음수가 되지 않도록 제어
            if (nums[i] <= target) {
                candidate.add(nums[i]);  // 숫자 선택
                getCombination(nums, target - nums[i], i, answerList, candidate); // 같은 숫자를 다시 사용할 수 있도록 startIndex를 i로 유지
                candidate.remove(candidate.size() - 1);  // 선택한 숫자 제거 (백트래킹)
            }
        }
    }
}
