package leetcode.arraystring;

public class RemoveDuplicates1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeDuplicates(new int[]{1,2});
        s.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
    public static class Solution {
        /* non-decresing 순서의 e를 중복제거한 num arr 반환, 유니크 e개수 반환
          - loop돌면서 현재idx와 idx+1값이 다르면 nums[cnt++]에 idx+1값 셋팅
         */
        public int removeDuplicates(int[] nums) {
            int cnt = 1;

            for (int i = 0; i < nums.length-1; i++) {

                if (nums[i] != nums[i+1]) {

                    nums[cnt] = nums[i+1];
                    cnt++;
                }
            }

            return cnt;
        }
    }
}
