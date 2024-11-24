package leetcode.math;

import java.math.BigDecimal;

public class Pow {
    /*
    pow(x,n)을 구현하기 x^n

    - x는 double이고 -100~100
    - n은 int 범위 (-2^31 ~ 2^31-1)
    - x^n 은 -10000~10000 범위로만 줌

    todo
    - 소수점 반올림 처리가 필요한가?
    - n이 음수일때의 처리 (이때는 n이 int 한계치일때에 대한 계산을 어떻게 해줄지)
     */
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
        System.out.println(myPow(2.00000, -2147483648));
    }

    public static double myPow(double x, int n) {

        if (n == 0) return 1;
        if (n < 0) {
            x = 1/x;
        }

        double pow = 1;
        long exp = Math.abs((long) n);

        while (exp != 0) {
            if ((exp & 1) != 0 ) {
                pow *= x;
            }

            x *= x; // 2진수 1,2,4,8~ 지수에 맞게 x^n 여기서 n을 만들기 위해서 루프마다 거듭제곱 (x^1->x^2->x^4..)
            exp >>>= 1; // 비트 오른쪽으로 하나 옮기기
        }

        return pow;
    }
}
