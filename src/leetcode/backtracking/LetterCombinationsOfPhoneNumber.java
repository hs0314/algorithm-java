package leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinationsOfPhoneNumber {
    /*
    2~9 digit가 넘어올때 이에 상응되는 a~z까지의 매핑가능 문자열 전체 출력 (순서 상관없음)

    제한
    - digit길이 0~4 (4개라고 했을때 3*3*3*3니까 완전탐색 이슈 없음)

    todo
    - digit에 매핑되는 문자열 데이터 미리 생성
    - recursion으로 발생가능 조합 생성
     */
    public static void main(String[] args) {
        letterCombinations("23");
        letterCombinations("");
        letterCombinations("2");
    }

    public static List<String> letterCombinations(String digits) {

        List<String> resultList = new ArrayList<>();

        // digit 매핑 문자열 기준데이터 생성
        final Map<Integer, List<String>> digitMappingStringMap = Map.of(
                2, Arrays.asList("a","b","c"),
                3, Arrays.asList("d","e","f"),
                4, Arrays.asList("g","h","i"),
                5, Arrays.asList("j","k","l"),
                6, Arrays.asList("m","n","o"),
                7, Arrays.asList("p","q","r","s"),
                8, Arrays.asList("t","u","v"),
                9, Arrays.asList("w","x","y","z")
        );

        // 조합 생성
        if (digits.length() > 0) {
            recursion(digits, digitMappingStringMap, new ArrayList<>(), resultList);
        }

        return resultList;
    }

    public static void recursion(String digits, Map<Integer, List<String>> map, List<String> picked, List<String> resultList) {

        // return
        if(digits.length() == picked.size()) {
            resultList.add(picked.stream().collect(Collectors.joining()));
            return;
        }

        // recursion
        int targetDigit = digits.charAt(picked.size()) - '0';
        for (String s : map.get(targetDigit)) {
            picked.add(s);
            recursion(digits, map, picked, resultList);
            //picked.remove(s); // picked가 call by ref이므로 직전 선택은 제거 -> remove로는 동일 객체 있을때 이슈가 될 수 있음
            picked.remove(picked.size()-1);
        }
    }
}
