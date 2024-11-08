package leetcode.arraystring;

public class ProductOfArrayExceptSelf {
    /*
     * nums int arr에서 answer[i]가 nums[i] 제외한 모든 곱 반환하도록
     * 
     * 제한
     * - num[] len 2~100000
     * - nums값 -30~30 (특정곱셈이 int 값 보장)
     * - 나눗셈 op 못씀, O(N)
     * 
     * todo
     * - 모든곱을 구해놓고 loop 돌면서 nums[i]로 나눈값? (nums[i] == 0인 케이스 는 0으로 셋팅)
     *   -> 0이 있으면 모든곱을 구하는게 의미없음
     * - 0~특정idx까지의 곱, 특정idx~끝까지의 곱 => 해당 데이터를 O(N)에 만들고 loop돌면서 answer Arr 계산
     * 
     */
    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1,2,3,4}));
        System.out.println(productExceptSelf(new int[]{-1,1,0,-3,3}));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] answerArr = new int[nums.length];
        int[] productUntil = new int[nums.length];
        int[] productFrom = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            
            // 시작 / 종료 idx에 대한 곱셈 처리

            productUntil[i] = nums[i] * (i > 0 ? productUntil[i-1] : 1);
            productFrom[nums.length - 1 - i] = nums[nums.length - 1 - i] * (i > 0 ? productFrom[nums.length - i] : 1);

        }

        for (int i=0;i<nums.length;i++) {
            int productUntilIdx = i - 1;
            int productFromIdx = i + 1;

            int answer = 1;
            if (productUntilIdx >= 0) {
                answer *= productUntil[productUntilIdx];
            }

            if (productFromIdx < nums.length) {
                answer *= productFrom[productFromIdx];
            }

            answerArr[i] = answer;
        }

        return answerArr;

    }
}
