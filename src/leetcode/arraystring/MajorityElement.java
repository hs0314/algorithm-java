package leetcode.arraystring;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.majorityElement(new int[]{3});
        s.majorityElement(new int[]{3,2,3});
        s.majorityElement(new int[]{2,2,1,1,1,2,2});
    }
    public static class Solution {
        /*
        majority e는 n/2번 이상 나오는거고 이건 항상 있는걸로
        O(n)?
         */
        public int majorityElement(int[] nums) {

            Map<Integer, Integer> chkMap = new HashMap<>();
            int majorityElement = 0;

            for(int i=0;i<nums.length;i++){
                chkMap.put(nums[i], chkMap.getOrDefault(nums[i], 0) + 1);

                if (i >= nums.length / 2 && chkMap.get(nums[i]) > nums.length / 2) {
                    majorityElement = nums[i];
                    break;
                }
            }

            return majorityElement;
        }
    }
}
