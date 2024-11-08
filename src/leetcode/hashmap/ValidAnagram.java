package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.isAnagram("aabb","abbb");
        s.isAnagram("anagram","nagaram");
        s.isAnagram("rat","car");
    }

    public static class Solution {
        /*
        두 문자열 s,t 받고 t가 s의 애너그림인지 판단
        -> 문자열 내 char를 재배열해서 만들수있는지 여부

        제한
        - s,t 길이 1~50000 (int sum 문제없음)

        todo
        - s가 기준이므로 s와 t에 대한 char-count map 생성
        - t char-count 맵 기준으로 s map이랑 카운트 비교
        - 문자열 수가 다르면 map생성 상관없이 fals

        tc
        - s,t 길이가 다른 경우
         */
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            //todo : char-count map 생성
            int[] charArr = new int[26];

            for(int i=0;i<s.length();i++) {
                charArr[s.charAt(i) - 'a']++;
                charArr[t.charAt(i) - 'a']--;
            }

            //todo : t 기준 s map과 카운트 비교
            // ** Integer에 대해서 자바는 -128~127 범위에 대해서만 캐싱하므로, equals를 쓰자
            for(int count : charArr) {
                if (count != 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
