package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
    3수의 합이 0인 모든 해 구하기 (i,j,k다 다름)

    제한
    - num 3<= len <= 3000 (완전탐색 불가)
    - num값 -100000 ~ 100000 (int 가능)
    - 동일 해를 answerlist에 담으면 안됌 (순서는 상관없음)

    todo
    - O(N)동안 i를 픽스하고 그 뒷숫자 j,k에 대한 투포인터로 선택 (o(n2))
    - 동일한 숫자에 대해서 중복해가 나오지 않도록 하려면..?
    - 투포인터 처리를 위한 sort (o(nlogn))

    tc
    - 중복해가 나올 수 있는 케이스
     */
    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
        threeSum(new int[]{2,2,2,-1,-1,-1,-1,-1,-1});
        threeSum(new int[]{0,1,1});
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answerList = new ArrayList<>();

        Arrays.sort(nums);

        for (int i=0;i<nums.length-2;i++) {

            // 중복해 방지
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // i fix 상태에서 투포인터로 j,k 선택
            int j = i+1;
            int k = nums.length-1;

            while (j < k) {

                if (nums[i]+nums[j]+nums[k] == 0) {

                    answerList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    // j중복 방지
                    while (nums[j-1] == nums[j] && j < k) {
                        j++;
                    }

                } else if (nums[i]+nums[j]+nums[k] > 0) {
                    k--;
                } else if (nums[i]+nums[j]+nums[k] < 0) {
                    j++;
                }
            }
        }

        return answerList;
    }
}

