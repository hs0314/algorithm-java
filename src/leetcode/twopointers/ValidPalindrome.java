package leetcode.twopointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution_ValidPalindrome s = new Solution_ValidPalindrome();
        s.isPalindrome("A man, a plan, a canal: Panama");
        s.isPalindrome("race a car");
    }
}

class Solution_ValidPalindrome{
    /*
    대문자->소문자 변환 AND 공백, 알파벳아닌 문자 삭제해서 팰린드롬 여부 판단
     */
    public boolean isPalindrome(String s) {

        /* 정규표현식 사용 시 runtime beats 40.7%나옴
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }

        return true;
         */

        int startIdx = 0;
        int endIdx = s.length()-1;

        while(startIdx <= endIdx) {
            if(!isValidStr(s.charAt(startIdx)) || !isValidStr(s.charAt(endIdx))){
                if(!isValidStr(s.charAt(startIdx))){
                    startIdx++;
                }
                if(!isValidStr(s.charAt(endIdx))){
                    endIdx--;
                }
            } else {
                char s1 = s.charAt(startIdx);
                char s2 = s.charAt(endIdx);

                if(s1 >= 65 && s1 <= 90){
                    s1 += 32;
                }
                if(s2 >= 65 && s2 <= 90){
                    s2 += 32;
                }

                if(s1 != s2){
                    return false;
                }
                startIdx++;
                endIdx--;
            }
        }

        return true;
    }

    public boolean isValidStr(char c){
        // 숫자 48~57 / 알파벳소문자 97~122
        return (c >= 48 && c <= 57) || (c >= 97 && c <= 122) || (c >= 65 && c <= 90);
    }
}
