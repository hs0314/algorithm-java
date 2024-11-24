package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<Integer> candidate = new ArrayList<>();
        List<List<Integer>> answerList = new ArrayList<>();


        perm(nums, answerList, candidate);
        System.out.println(answerList);
    }   
    
    public static void perm(int[] nums, List<List<Integer>> answerList, List<Integer> candidate) {
        // chk
        if (candidate.size() == nums.length) {
            // add
            answerList.add(new ArrayList<>(candidate));
        }

        // process & recursion
        for (int i=0;i<nums.length;i++) {
            // 이미 candidate에 들어있지 않은 요소만 추가
            if (!candidate.contains(nums[i])) {
                
                candidate.add(nums[i]);
                perm(nums, answerList, candidate);
                // 다 처리한 다음에는 loop내 다른 nums[i]에 대해서 구할 수 있도록 직전에 넣은 것 제외
                candidate.remove(candidate.size()-1);
            }
        }
    }
}
