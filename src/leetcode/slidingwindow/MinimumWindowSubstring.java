package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /*
    두 문자열 s,t에서 t의 문자열이 모두 포함된 s내 minimum window 문자열 출력
    답이 없으면 빈문자열 반환

    제한
    - s,t 길이는 1~100000 (o(n)으로 풀어야함)
    - o(m+n) 시간

    todo
    - s기준 window는 최소 t길이만큼 잡아야함
    - s기준 window내에 t의 문자열이 모두 포함되는지 여부 체크
        => map2개로 관리? (문자열:개수)
        => 만족하는 window부터 찾고 narrowing처리
    - fixme : O(mn) -> O(m+n) 개선
     */
    public static void main(String[] args) {
        System.out.println(minWindow("aa","aa"));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a","a"));
        System.out.println(minWindow("a","aa"));
    }

    public static String minWindow(String s, String t) {

        Map<String, Integer> smap = new HashMap<>();
        Map<String, Integer> tmap = new HashMap<>();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        String answer = "";

        // tmap생성
        for (char c : t.toCharArray()) {
            tmap.put(String.valueOf(c), tmap.getOrDefault(String.valueOf(c), 0) + 1);
        }

        // window 생성
        // fixme(아래 방법은 o(mn)일거같은데
        for (int i=0;i<s.length();i++) {
            String curChar = String.valueOf(s.charAt(i));

            smap.put(curChar, smap.getOrDefault(curChar, 0) + 1);

            // t포함여부 체크
            // 현재 window size가 t.length보다 커야함
            if (i-left+1 >= t.length()) {

                int containCnt = 0;
                for (String key : tmap.keySet()) {
                    if (smap.containsKey(key) && smap.get(key) >= tmap.get(key)) {
                        containCnt += tmap.get(key);
                    }
                }

                // 포함 O
                if (containCnt == t.length()) {
                    if (i-left+1 < minLen) {
                        minLen = i-left+1;
                        answer = s.substring(left, i+1);
                    }

                    //window narrowing
                    // 포함여부 O 유지한채로 줄여야함
                    String narrowTarget = String.valueOf(s.charAt(left));
                    while (i-left+1 > t.length()
                            && (!tmap.containsKey(narrowTarget)
                                || (tmap.containsKey(narrowTarget) && smap.get(narrowTarget)-1 >= tmap.get(narrowTarget)))) {

                        // narrowing하면서 해당 문자값 카운트가 0이되면 체크 map에서 제거
                        smap.put(narrowTarget, smap.get(narrowTarget) - 1);
                        if (smap.get(narrowTarget) <= 0) {
                            smap.remove(narrowTarget);
                        }

                        left++;
                        narrowTarget = String.valueOf(s.charAt(left));

                        // narrowing한 window내 답 다시 구하기
                        if (i-left+1 < minLen) {
                            minLen = i-left+1;
                            answer = s.substring(left, i+1);
                        }
                    }
                }
            }
        }

        return answer;
    }
}
