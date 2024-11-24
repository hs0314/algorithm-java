package leetcode.hashmap;

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
    /*
     String배열에서 anagram을 찾아서 그룹핑 (문자열의 내부 요소가 동일한 쌍)

     제한
     - 1 <= input 개수 <= 10000
     - 0 <= 하나의 문자열길이 <=100 (길이 0 조심)

     todo
     - 각 문자열에 대해서 sort (문자열길이100이니까 nlogn * 10000(input개수 시 문제 없음)
     - sort이후 map에 해당 sort값 key로 원 string 그룹핑

     */
    public static void main(String[] args) {

        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        groupAnagrams(new String[]{"eaaa","aeee" });
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groupMap = new HashMap<>();
        List<List<String>> answerList = new ArrayList<>();

        for (String str : strs) {
            char[] strCharArray = str.toCharArray();
            Arrays.sort(strCharArray);
            String key = String.valueOf(strCharArray);

            groupMap.computeIfAbsent(key, k -> new ArrayList<>());
            groupMap.get(key).add(str);
        }

        for (Map.Entry<String,List<String>> entry : groupMap.entrySet()) {
            answerList.add(entry.getValue());
        }

        return answerList;
    }

}
