package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.wordPattern("abba","dog cat cat dog");
        s.wordPattern("abba","dog cat cat fish");
        s.wordPattern("aaaa","dog cat cat dog");
    }

    public static class Solution {
        /*
        pattern, s가 주어졌을때 해당 패턴대로 s(공백제외)가 매핑되는지 체크

        제한
        - pattern 길이 1~300
        - s길이는 1~3000
        - s는 싱글스페이스 공백으로 나눠짐

        todo
        - s를 ' '으로 split 해서 순서대로 패턴과 매칭 O(N)
        - pattern의 charAt(i) 기준 splitedS[i]와 매칭

        tc
        - pattern이 1인 경우, s가 1인 경우
        - s split건수와 pattern건수가 맞지 않는 케이스
         */
        public boolean wordPattern(String pattern, String s) {
            String[] splitedS = s.split(" ");
            Map<String, String> patternMap = new HashMap<>();
            
            if (splitedS.length != pattern.length()) {
                
            }

            for (int i=0;i<pattern.length();i++) {
                if (patternMap.containsKey(String.valueOf(pattern.charAt(i)))) {
                    if (!splitedS[i].equals(patternMap.get(String.valueOf(pattern.charAt(i))))) {
                        return false;
                    }

                } else {
                    // todo: map에 추가 매핑 넣기
                    if (patternMap.containsValue(splitedS[i])) {
                        return false;
                    }

                    patternMap.put(String.valueOf(pattern.charAt(i)), splitedS[i]);
                }
            }

            return true;
        }
    }
}
