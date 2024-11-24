package leetcode;

public class SumOfTwoIntegers {
    /*
     * a,b값 기준 +,- 연산자 사용하지 않고 sum 구하기
     * 
     * contraints
     * - -1000 <= a,b <= 1000
     * 
     * todo
     * - 어떤 알고리즘을 선택, 선택이유
     *  - bit 연산자를 사용
     * - 해야될 것
     *  - 어떤 비트연선자를 사용해야하는가?
     *     00 + 00 = 00  / 01 + 00 = 01, 00 + 01 = 01 해당 연산을 거의 만족하는게 xor이지만 01 + 01 = 10 같이 올림이 발생하는 경우 대응 불가
     *     올림 발생에 대해서는 (a & b) << 1 로 계산
     *     
     * 
     * tc / verify
     * - 올림이 발생하는 케이스 ex) 1(01), 3(11)
     */
    public static void main(String[] args) {
        int a=1; // 01
        int b=-3; // 11

        while(b != 0) {
            int extraAdd = (a & b) << 1; // 올림 연산

            a = a^b;
            b = extraAdd; 

        }

        System.out.println(a);
    }

}