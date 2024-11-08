package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.canConstruct("a","b");
        s.canConstruct("aa","ab");
        s.canConstruct("aa","aab");
    }

    public static class Solution {
        /*
        magazine의 단어를 한번씩 사용해서 ransomnote 를 만들 수 있는가
         */
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> chkMap = new HashMap<>();

            for (char c : ransomNote.toCharArray()) {
                chkMap.put(c, chkMap.getOrDefault(c, 0) + 1);
            }

            for (char c : magazine.toCharArray()) {
                if (chkMap.containsKey(c) && chkMap.get(c) > 0) {
                    chkMap.put(c, chkMap.get(c) - 1);

                    if (chkMap.get(c) <= 0) {
                        chkMap.remove(c);
                    }
                }
            }

            if(chkMap.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
