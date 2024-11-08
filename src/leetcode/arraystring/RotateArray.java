package leetcode.arraystring;

import java.util.Arrays;

public class RotateArray {
    /*
     * int array num을 K번 오른쪽으로 밀었을때의 결과
     * 
     * 제한
     * - nums개수 1~100000
     * - nums는 int범위
     * - k 0~10000
     *
     * todo (O(N))
     * - nums.length만큼 rotate하면 원위치가됌 => k % nums.length로 k단축
     * - rotate는 어떻게 하는게 편한가?
     * - 동일한 nums 배열을 써야하는가? => return void임
     * 
     * tc
     * - length 1일때
     */
    public static void main(String[] args) {
        rotate(new int[] { 1 }, 1000);
        rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
        rotate(new int[] { 1, -100, 3, 99 }, 2);
    }

    public static void rotate(int[] nums, int k) {

        final int[] critn = Arrays.copyOf(nums, nums.length);
        k = k % nums.length;

        // rotate
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = critn[i];
        }
    }
}
