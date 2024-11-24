package leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
    문자열s에서 char 반복이없는 최대 길이 반환

    제한
    - s len 0~50000 (0처리 주의)

    todo
    - 연속적인 window를 구하는 방식 -> 슬라이딩 윈도우 => i를 증가시켜가면서 left의 window를 줄여가는 방식 O(N)
    - 중복체크를 위해서 set 사용
    - loop돌면서 set에 넣고 중복발생시 left 증가
     */
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring(""));
//        System.out.println(lengthOfLongestSubstring("dvdf"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> chkSet = new HashSet<>();
        int left = 0;
        int answer = 0;

        for (int i=0;i<s.length();i++) {

            char curChar = s.charAt(i);

            if (chkSet.contains(curChar)) {

                // 현재 기준idx(i)와 동일한 값이 set에서 없어질때까지 narrowing
                while (chkSet.contains(curChar)) {
                    chkSet.remove(s.charAt(left));
                    left++;
                }
            }

            // 기준 idx는 loop별로 무조건 추가
            chkSet.add(curChar);
            answer = Math.max(answer, i-left+1);
        }

        return answer;
    }
}
