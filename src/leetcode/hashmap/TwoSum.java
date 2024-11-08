package leetcode.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {
    public static void main(String[] args) {
        Solution s = new Solution();

       // s.twoSum(new int[]{2,7,11,15},9);
        s.twoSum(new int[]{3,2,4},6);
       // s.twoSum(new int[]{3,3},6);
    }

    public static class Solution {
        /*
        nums 요소 두개 합산으로 target을 만들 수 있는 조합 반환
        (인풋별 정답은 하나로 가정)

        제한
        - nums 합, 처리 int 범위 안넘음
        - nums 개수 2~10000

        todo
        - 10000 중 무작위 2개 선택도 가능하지만 O(n2)보다 빠르게 푸는 방법 필요
        - m1) List (idx:value) 기준 value로 소팅해서 투포인터 처리 (이것도 느림..)
        - m2) 소팅(nlogn)없이 처리할 수 있는 방법은? hashmap사용? o(N)
            => nums돌면서 map에 value key, index를 value로 넣고..
        */
        public int[] twoSum(int[] nums, int target) {

            // value:idx
            Map<Integer,Integer> numMap = new HashMap<>();
            int[] answer = new int[2];

            for(int i=0;i<nums.length;i++){
                numMap.put(nums[i], i);
            }

            for(int i=0;i<nums.length;i++){
                if (numMap.containsKey(target - nums[i]) && i != numMap.get(target - nums[i])) {
                    answer[0] = i;
                    answer[1] = numMap.get(target - nums[i]);
                    break;
                }
            }

            return answer;


            // 정렬 후 투포인터 O(NlogN)
        /*
            List<String> numList = new ArrayList<>();

            for(int i=0;i<nums.length;i++){
                numList.add(nums[i] + ":" + i);
            }

            // value값 기준 오름차순 정렬
            numList.programmers.sort((o1,o2) ->Integer.parseInt(o1.split(":")[0]) - Integer.parseInt(o2.split(":")[0]));

            int left = 0;
            int right = nums.length-1;
            int[] answer = new int[2];

            while (left < right) {
                int leftVal = Integer.valueOf(numList.get(left).split(":")[0]);
                int rightVal = Integer.valueOf(numList.get(right).split(":")[0]);

                if (leftVal + rightVal == target) {
                    answer[0] = Integer.valueOf(numList.get(left).split(":")[1]);
                    answer[1] = Integer.valueOf(numList.get(right).split(":")[1]);
                    break;
                } else if (leftVal + rightVal < target) {
                    left++;
                } else if (leftVal + rightVal > target) {
                    right--;
                }
            }

            return answer;
         */
        }
    }
}
