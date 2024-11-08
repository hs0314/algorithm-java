package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GroupAnagrams {
    public static void main(String[] args) {
        /*
         * String배열에서 anagram을 찾아서 그룹핑 (문자열의 내부 요소가 동일한 쌍)
         * 
         * constraints
         * - 1 <= input 개수 <= 10000
         * - 0 <= 하나의 문자열길이 <=100 (길이 0 조심)
         * 
         * todo
         * - 애너그램 판단
         * - 그룹핑
         * 
         * - strs를 돌면서 key 별 리스트
         * - key를 뭘로 볼건가
         * ex) abc, cba 를 묶을 수 있는 key 식별 => set에넣고 sort해서 쭉 붙인 String? (logN 의 정렬을 N번 =>
         * nlogn)
         *  - Set을 써서 key를 만들때 aaaab, bbbba가 같아짐.. 요소들의 건수까지 맞춰야함 (a1b3.. 형식으로 key)
         * 
         * tc
         * - 길이 0 N개
         * - 그룹이 단 한개 있을때
         * 
         * 개선
         * - TreeMap을 사용하면 느릴 수 밖에 없음.. 해당 자료구조말고  str의 char arr자체를 sort하고 그대로 key로 사용
         */

        //String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        String[] strs = new String[] { "eaaa","aeee" };

        Map<String, List<String>> groupMap = new HashMap<>();

        for (String str : strs) {

            char[] sortedCharArr = str.toCharArray();
            Arrays.sort(sortedCharArr);

            String stringKey = new String(sortedCharArr);

            // computeIfAbsent로 key가 없을때 새로운 list를 셋팅하고 이후 put을 따로 할 필요 없음 ->이미 주소값 기반으로 가져왔음
            List<String> group = groupMap.computeIfAbsent(stringKey, key -> new ArrayList<>());
            group.add(str);
        }

        // Map요소 list화해서 출력
        List<List<String>> answer = new ArrayList<>(groupMap.values());

        System.out.println(answer);

    }
}
