package leetcode.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    /*
    문자열 s와 문자열리스트 wordDict가 있을때 s가 dict안의 문자열조합으로 생성되는지 확인 (단어 재사용 가능)

    제한
    - s길이 1~300
    - 리스트 건수 1~1000
    - 리스트내 문자열 길이 1~20

    todo
    - dp로 처리한다면 s 문자열별 처리가능여부를 가지도록..? 건수가 1000건이고 s길이가 300이면 O(s.len * dict.size) ?
    - 직전 idx까지 word생성 성공했다면 현 idx부터 다시 wordDict loop돌면서 비교

    tc
    - 문자열 길이 1인 케이스 idx 오류 없는지 확인
     */
    public static void main(String[] args) {
        wordBreak("abcd", Arrays.asList("a","abc","b","cd"));
        wordBreak("leetcode", Arrays.asList("leet","code"));
        wordBreak("applepenapple", Arrays.asList("apple","pen"));
        wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isPossible = new boolean[s.length()];

        for (int i=0;i<s.length();i++) {

            // 직전 idx까지 만드는게 가능했다면 현 idx에서 추가확인
            if (i==0 || (i > 0 && isPossible[i-1]) ) {
                String start = String.valueOf(s.charAt(i));

                for (String word : wordDict) {
                    // word를 붙일 수 있으면 현재 s.idx + word.length를 true 셋팅
                    if (word.startsWith(start) && i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
                        isPossible[i + word.length()-1] = true;
                    }
                }
            }
        }

        return isPossible[s.length()-1];
    }
}
