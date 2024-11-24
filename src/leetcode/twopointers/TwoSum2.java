package leetcode.twopointers;

public class TwoSum2 {
    /*
    오름차순 array내 두 idx 값 합산이 target과 같은 인덱스 반환

    제한
    - array 요소 개수 2~30000 ( O(n2)은 시간초과)
    - number값, target값 범위 -1000~1000 (int범위 넘지 않음)
    - 유일해가 있음을 보장

    todo
    - 정렬된 array이고 완탐이 불가하므로 투포인터 (o(n))
    - left, right를 정해서 left < right일떄까지 sum이 target이 되도록 조정

    tc
    - 요소가 2개인 경우 (해가 있음을 보장하므로.. 상관없음)
     */
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2,7,11,15}, 9));
        System.out.println(twoSum(new int[]{1,2,3,4,5,6,7,8,9,10}, 19));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] answerArr = new int[2];

        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if(numbers[left] + numbers[right] > target) {
                right--;
            } else {
                // 답
                answerArr[0] = left+1;
                answerArr[1] = right+1;
                break;
            }
        }

        return answerArr;
    }
}
