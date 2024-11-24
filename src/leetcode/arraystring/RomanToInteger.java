package leetcode.arraystring;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    /*
    로마숫자 -> int 변환

    todo
    - 매칭되는 symbol <-> int 배열 선언
        - VI, XI 형식도 만들어 두는게 편할듯?
    - idx loop타면서 변환된 int sum
     */
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        final Map<String, Integer> symbolIntMap = Map.ofEntries(
                Map.entry("I", 1),
                Map.entry("V", 5),
                Map.entry("X", 10),
                Map.entry("L", 50),
                Map.entry("C", 100),
                Map.entry("D", 500),
                Map.entry("M", 1000)
        );

        int answer = 0;

        for (int i=0;i<s.length();i++) {
            int num = symbolIntMap.get(String.valueOf(s.charAt(i)));

            if (i < s.length()-1 && num < symbolIntMap.get(String.valueOf(s.charAt(i+1)))) {
                // IV 같은 케이스는 현 idx는 빼준다
                answer -= num;
            } else {
                answer += num;
            }
        }

        return answer;
    }
}
