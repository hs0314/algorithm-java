package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        /*
        - 3수의 합이 0인 모든 해 구하기 (i,j,k다 다름)
        - num 3<= len <= 3000
        - 동일 triplets를 answerlist에 담으면 안됌
        
        note
        - 완탐 불가
        - 포인터 3개두고 i,j,k 다 다르니까 O(N)에 가능? 혹은 i는 계속 1씩 증가시키고 그 내부에서 투포인터 -> O(N2)
        - left,right,mid 두고 움직이는 조건을 어떻게 할것인가?

        ?
        - 해가 없는 경우
        
        엣지케이스
        - 
         */   

        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> answerList = new ArrayList<>();

        Arrays.sort(nums);

        for (int i=0;i<nums.length-2;i++) {

            // 중복 방지를 위해서 직전 처리와 동일한 i이면 skip
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // i를 픽스해서 여기서 투포인터
            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    answerList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }

                // 어떤 포인터를 언제 움직일지에 대한 규칙
                if (sum > 0) {
                    int prev = nums[right];
                    right--;
                    
                    // 동일 값에 대해서 스킵
                    while (prev == nums[right]) {
                        right--;
                    }
                } else {
                    int prev = nums[left];
                    left++;
                    while (prev == nums[left]) {
                        left++;
                    }
                }

            }
        }
        for(List<Integer> ans : answerList) {
            for(int a : ans) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}

