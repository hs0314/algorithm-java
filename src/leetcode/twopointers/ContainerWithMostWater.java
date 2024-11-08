package leetcode.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }

    public static class Solution {
        /*
        i번째 높이 height[i]
        (left-right) * min(height[left], height[right]) 최대 만들기

        - n < 10의5제곱 -> O(n2)으로 풀면 간당간당함 => 투포인터 O(N)
        - x를 움직일떄는 y가 늘어날때까지 (x가 줄어드는데 y는 커져야함)

          ? 좌우중에 어떤걸 먼저 움직일건가?
           -> x가 1줄어드는건 동일하니 left, right중 다음 height가 더큰것 움직이는게? (X)
           -> left,right를 현재 idx가지의 max height으로 보고 계산하는건?
           -> hint: 포인터를 더 lower line쪽으로 움직여라 -> 컨테이너 높이를 높게 가져가야하고 높이는 더 짧은 hegiht이므로, 더 짧은 높이인 idx를 움직여서 답을 찾아라

        - 엣지케이스
         => 마지막에 몰려있는거

         - 정리

         */
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length-1;
            int max = -1;

            while (left < right) {
                int xlen = right - left;
                int ylen = Math.min(height[left], height[right]);

                if (max < xlen * ylen) {
                    max = xlen * ylen;
                }

                if (height[left] >= height[right]) {
                    right--;
                } else {
                    left++;
                }
            }

            return max;
        }
    }
}
