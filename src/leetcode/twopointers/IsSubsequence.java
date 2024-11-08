package leetcode.twopointers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class IsSubsequence {
    public static void main(String[] args) {
        Solution s = new Solution();

            s.isSubsequence("abc","ahbgdc");
            s.isSubsequence("axc","ahbgdc");
    }

    public static class Solution {
        /*
        s -> t의 subsequence?
        - s,t에 idx하나씩 돌면서 => O(s*t) 100 * 1000
         */
        public boolean isSubsequence(String s, String t) {
            int tidx = 0;
            for (char sc : s.toCharArray()) {
                boolean containsInOrder = false;

                for (int i=tidx;i<t.length();i++) {
                    if (sc == t.charAt(i)) {
                        tidx = i+1;
                        containsInOrder = true;
                        break;
                    }
                }

                if (!containsInOrder) {
                    return false;
                }
            }

            return true;
        }
    }
}
