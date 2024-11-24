package leetcode.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubarraySum {
    /*
    자연수 num arr에서 target보다 크거나 같은 subarray 길이 출력
    만족하는 답이 없으면 0 반환

    제한 (int 범위내)
    - target은 int범위
    - num length 1~100000
    - nums[i] 1~10000

    todo
    - sum이 target 보다 크게 되는 순간, left idx를 올려가면서 window narrowing (슬라이딩 윈도우) => O(N)
     */
    public static void main(String[] args) {
        minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        minSubArrayLen(4, new int[]{1, 4, 4});
        minSubArrayLen(11, new int[]{1, 1, 1, 1});

    }

    public static int minSubArrayLen(int target, int[] nums) {

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;

        for (int i=0;i<nums.length;i++) {
            currentSum += nums[i];

            // window narrow
            while (currentSum >= target) {
                // min값 구하기
                answer = Math.min(answer, i - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
