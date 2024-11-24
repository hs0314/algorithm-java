package leetcode.twopointers;

public class ContainerWithMostWater {
    /*
    height[i] 값은 x의 높이 값
    두 x를 골라서 해당 높이들로 만들어지는 직사각형의 면적 최대값 구하기

    제한
    - 개수 2~100000 (o(n2) 불가)
    - 높이 0~10000

    todo
    - x=0, n-1 idx부터 각 이후 max값이 증가할 수 있는 방향으로 좌++ 혹은 우--
    - 좌<우 인 동안 지속적으로 x값 변동
    - 현재 좌,우의 높이값이 동일하면 아무거나 움직여도 상관이 없음?

    tc
    - 높이 0인 케이스
    - 겉은 높이가 낮고 내부높이만 높은 경우
     */
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{0,0}));
        System.out.println(maxArea(new int[]{0,1}));
        System.out.println(maxArea(new int[]{1,1,1,8,9,100,1,1,1}));
    }

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int answer = 0;

        while (left < right) {

            answer = Math.max(answer, (right-left) * Math.min(height[left], height[right]));
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return answer;
    }
}
