package leetcode.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.isIsomorphic("badc","baba");
        //s.isIsomorphic("foo","bar");
        //s.isIsomorphic("paper","title");
    }

    public static class Solution {
        /*
        s,t valid ascii, s/t 길이 같음
         */
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> convertMap = new HashMap<>();
            Set<Character> usedSet = new HashSet<>();

            for(int i=0;i<s.length();i++) {
                if(convertMap.containsKey(s.charAt(i))) {
                    if (convertMap.get(s.charAt(i)) != t.charAt(i)){
                        return false;
                    }
                } else {
                    // 이미 다른 s.char이랑 매핑된 t.char에 대해서 s.char이 다르게 들어오는 경우..
                    if (usedSet.contains(t.charAt(i))) {
                        return false;
                    }
                    convertMap.put(s.charAt(i), t.charAt(i));
                    usedSet.add(t.charAt(i)); // 이미 매핑된 char 추가
                }
            }

            return true;
        }
    }
}
