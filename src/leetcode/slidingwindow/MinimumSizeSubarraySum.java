package leetcode.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
        s.minSubArrayLen(4, new int[]{1,4,4});
        s.minSubArrayLen(11, new int[]{1,1,1,1});

    }

    public static class Solution {
        public int minSubArrayLen(int target, int[] nums) {

            int min = Integer.MAX_VALUE;
            int left = 0;
            int sum = 0;

            // target만큼 윈도우 사이징
            for(int i=0;i<nums.length;i++){
                sum += nums[i];

                // 조건이 만족되는 순간부터 윈도우 사이즈를 줄여서 min을 찾음
                while(sum >= target) {
                    if(min > i-left + 1) {
                        min = i-left + 1;
                    }

                    sum -= nums[left++];
                }
            }
            if (min == Integer.MAX_VALUE) {
                return 0;
            } else {
                return min;
            }
        }
    }
}
