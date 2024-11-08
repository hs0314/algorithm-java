package leetcode.arraystring;

import java.util.Arrays;

public class JumpGame {
    /*
     * int nums[] -> 0번 인덱스에서 시작해서 각 인덱스에서 maximum점프 가능값(이하 값 가능) => 마지막 인덱스 도달 가능여부 반환
     * 
     * 제한
     * - nums값은 0~100000
     * - 길이는 1~10000 (o(n2) 가능하긴함)
     * - 앞 idx 되돌아가는것이 가능한가? (불가)
     * 
     * todo
     * - dp로 각 idx 도달 가능여부 판단?
     * - idx0 ~ n-1까지 
     * - O(n2) 보다 빠른 풀이는?
     */
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public static boolean canJump(int[] nums) {
        
        int[] maxJumpFromIdx = new int[nums.length];
        Arrays.fill(maxJumpFromIdx, -1);

        maxJumpFromIdx[0] = nums[0];

        for(int i=1;i<nums.length;i++){

            // dp로 직전까지의 maxjump와 현재 idx의 nums을 비교
            // 도달 가능여부 판단
            if (maxJumpFromIdx[i-1] + (i-1) >= i) {
                maxJumpFromIdx[i] = Math.max(nums[i], maxJumpFromIdx[i-1]-1);
            }
        }

        return maxJumpFromIdx[nums.length-1] > -1 ? true : false;
    }
}
