package leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.lengthOfLongestSubstring("dvdf");
        s.lengthOfLongestSubstring("bbbbb");
        s.lengthOfLongestSubstring("pwwkew");

    }

    public static class Solution {
        /*
        char 반복없는 가장 긴 substr
        0 <= str 길이 <= 50000
        - 중복 체크 어떻게?
         */
        public int lengthOfLongestSubstring(String s) {

            int max = 0;
            int left = 0;
            Set<Character> dupChk = new HashSet<>();

            for(int i=0;i<s.length();i++) {
                if (dupChk.contains(s.charAt(i))) {

                    // 중복이 발생안할떄까지 윈도우 narrowing
                    while(dupChk.contains(s.charAt(i))) {
                        dupChk.remove(s.charAt(left++));
                    }
                }

                dupChk.add(s.charAt(i));

                if (max < i-left+1) {
                    max = i-left+1;
                }
            }

            return max;
        }
    }
}
