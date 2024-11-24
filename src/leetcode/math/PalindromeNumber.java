package leetcode.math;

public class PalindromeNumber {
    /*
    int x가 주어질때 palindrome 여부 반환

    제한
    - x는 int 범위

    todo
    - -부호 여부까지 판단해야하기 때문에 음수는 무조건 false
    - int를 string으로 반환 후, len/2까지 loop를 돌면서 i와 len-i 값 동등성 비교

     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(0));
    }

    public static boolean isPalindrome(int x) {

        String numStr = String.valueOf(x);

        if (x < 0) return false;

        for (int i=0;i<numStr.length()/2;i++) {
            if (numStr.charAt(i) != numStr.charAt(numStr.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
