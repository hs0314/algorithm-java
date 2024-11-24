package leetcode.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    /*
    정렬안된 nums배열에서 longest consecutive 길이 반환 O(N)필요
    -> 연속적인 숫자갯수

    제한
    - nums개수 0~100000
    - nums값들은 int 범위
    - O(N) 처리가 필요하면 정렬은 불가

    todo
    - 특정 treemap등 자료구조도 o(nlogn)이므로 사용 불가
    - ? num 요소가 하나면 1 반환?
    - set을 만들어두고 for loop돌면서 consecutive의 시작이 될수있는(n-1이 set에 없는)값부터 n+1 증가시키면서 length구하기

     tc
     - num개수 0, 1
     - 동일num consecutive
     */
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{}));
        System.out.println(longestConsecutive(new int[]{-1}));
        System.out.println(longestConsecutive(new int[]{-9999,-9998,-9997,1,2,3}));
        System.out.println(longestConsecutive(new int[]{99,100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    public static int longestConsecutive(int[] nums) {

        Set<Integer> chkSet = new HashSet<>();
        int maxLen = 0;

        for (int i : nums) {
            chkSet.add(i);
        }

        for (int num : nums) {

            // consecutive 시작점이 가능한 num부터 최대 length구하기
            if (!chkSet.contains(num-1)) {
               int len = 1;
               int curNum = num;

               while (chkSet.contains(curNum+1)) {
                   len++;
                   curNum++;
               }

               maxLen = Math.max(maxLen, len);
               if (maxLen > nums.length/2) break; // 이미 과반수이상의 consecutive len이 나왔으면 더 추가로 볼 필요 없음
            }
        }

        return maxLen;
    }
}
