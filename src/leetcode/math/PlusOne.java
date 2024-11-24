package leetcode.math;

public class PlusOne {
    /*
    digits array에 큰 수가 주어지고 여기에 1을 더했을때의 결과값을 반환

    제한
    - digit길이 1~100
    - 0으로 시작하는건 없음

    todo
    - 마지막 idx부터 0까지 loop를 돌면서 연산을 하나씩 처리
    - 올림때문에 자릿수가 하나 커지는 경우를 대비해서 digits에서 계산하고 이를 반대로 뒤집은 answer 반환
     */
    public static void main(String[] args) {
        System.out.println(plusOne(new int[]{1,2,3}));
        System.out.println(plusOne(new int[]{9}));
        System.out.println(plusOne(new int[]{4,3,2,1}));
    }

    public static int[] plusOne(int[] digits) {

        int addNum = 1;
        for (int i=digits.length-1;i>=0;i--) {
            int curDigit = digits[i];
            digits[i] = (curDigit + addNum) % 10;
            addNum = (curDigit + addNum) / 10;
        }

        if (addNum == 1) {
            // 자릿수가 늘어나면 자릿수증가 처리 후 반환
            int[] answer = new int[digits.length + 1];
            answer[0] = 1;
            for (int i=0;i<digits.length;i++) {
                answer[i+1] = digits[i];
            }

            return answer;
        }

        return digits;
    }
}
