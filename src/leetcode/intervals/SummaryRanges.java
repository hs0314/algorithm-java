package leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    /*
     * 정렬, uniq int 배열에서 연속되는 범위를 a->b 로 표현
     * string list 반환
     * 
     * 제한
     * - num은 int범위
     * - nums length 0~20 (0 조심)
     * 
     * todo
     * - loop돌면서 연속여부 판단 후 종료 시 anwerList 추가
     *
     */
    public static void main(String[] args) {
        int[] nums0 = new int[] {};
        int[] nums1 = new int[] { 0, 1, 2, 4, 5, 7 };
        int[] nums2 = new int[] { 0, 2, 3, 4, 6, 8, 9 };

        System.out.println(summaryRanges(nums0));
        System.out.println(summaryRanges(nums1));
        System.out.println(summaryRanges(nums2));

    }

    public static List<String> summaryRanges(int[] nums) {

        List<String> answerList = new ArrayList<>();

        int startIdx = 0;

        for (int i=0;i<nums.length;i++) {

            // 불연속여부 판단
            // 불연속이면 stratIdx 갱신
            if (i > 0 && nums[i] - nums[i-1] != 1) {

                if (i-1 == startIdx) {
                    answerList.add(String.valueOf(nums[startIdx]));
                } else {
                    answerList.add(String.format("%s->%s", nums[startIdx], nums[i-1]));
                }

                startIdx = i;
            }
        }

        // 마지막 idx 처리
        if (nums.length > 0) {
            if (nums.length - 1 == startIdx) {
                answerList.add(String.valueOf(nums[startIdx]));
            } else {
                answerList.add(String.format("%s->%s", nums[startIdx], nums[nums.length - 1]));
            }
        }

        return answerList;
    }
}
