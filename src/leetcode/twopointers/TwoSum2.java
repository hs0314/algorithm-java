package leetcode.twopointers;

public class TwoSum2 {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.twoSum(new int[]{-2,1,2}, 0);
        s.twoSum(new int[]{1,2,3,4,5,6,7,8,9,10}, 19);
    }

    public static class Solution {
        /*
         이미 increase order로 소팅된 numbers에서 2숫자 합이 target인 것 (답이 하나만 있도록 tc)
         - constant extra space만 써야함

         - 2 <= numbers.length <= 30000 (최대 O(nlogn), n2도 될듯)
         - 투포인터는 시간복잡도 O(N), 공간복잡도는 배열이외 공간 사용 X -> O(1)
         - 오름차순 배열이라는 특징때문에 투포인터 사용가능한듯

         - 엣지케이스 ?
          => 계속 같은값이 있고 답은 마지막에 있는 경우

          정렬되어 있는 배열에 한해서 O(N)으로 투포인터알고리즘 사용 및 해결 가능
         */
        public int[] twoSum(int[] numbers, int target) {

            int[] answer = new int[2];
            // 투포인터를 위한 좌우 idx
            int left = 0;
            int right = numbers.length-1;

            while (left < right) {
                if (numbers[left] + numbers[right] > target) {
                    right--;
                } else if (numbers[left] + numbers[right] < target) {
                    left++;
                } else if (numbers[left] + numbers[right] == target) {
                    // 답
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                    break;
                }
            }

            return answer;
        }
    }
}
