package leetcode.arraystring;

public class RemoveDuplicates2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeDuplicates(new int[]{1,1,1,2,2,3});
        s.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
    }
    public static class Solution {
        /* non-decresing 순서의 e를 중복제거한 num arr 반환, 유니크 e개수 반환
          - 동일 e는 최대 2번까지 허용
          - loop돌면서 현재idx와 idx+1값이 다르면 nums[cnt++]에 idx+1값 셋팅
         */
        public int removeDuplicates(int[] nums) {
            int dupCnt = 1;
            int currentIdx = 1;

            for (int i = 0; i < nums.length-1; i++) {

                if (nums[i] != nums[i+1]) {
                    nums[currentIdx++] = nums[i+1];
                    dupCnt = 1;
                } else {
                    dupCnt++;

                    if (dupCnt <= 2) {
                        nums[currentIdx++] = nums[i];
                    }
                }
            }

            return currentIdx;
        }
    }
}
