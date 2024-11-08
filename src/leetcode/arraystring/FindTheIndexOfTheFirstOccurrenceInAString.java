package leetcode.arraystring;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    /*
    두 string a,b에서 a가 b의 어떤 index에 처음 나오는지 index반환 (불가시 -1)

    제한
    - a,b 길이 1~10000
    - 소문자로만 이루어져있음

    todo
    - neddle의 시작 문자열인 경우부터 탐색을해서 포함여부 판단 O(N)
    - String.indexOf() 사용

    tc
    - 문자열길이가 1이어서 for문을 안타는 케이스 체크
    - needle이 haystack 마지막 idx에 나열되어있는 케이스 (arrayoutofbounds)
     */
    public static void main(String[] args) {
        System.out.println(strStr("abcdefg", "efg"));
        System.out.println(strStr("a", "ab"));
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }

    public static int strStr(String haystack, String needle) {

        int firstOccurenceIdx = -1;
        for (int i=0;i<haystack.length();i++) {
            if (haystack.charAt(i) == needle.charAt(0) && i + needle.length() <= haystack.length()) {
                // chk
                if (needle.equals(haystack.substring(i, i + needle.length()))) {
                    //todo : 마지막idx 포함여부 체크
                    firstOccurenceIdx = i;
                    break;
                }
            }
        }

        return firstOccurenceIdx;
    }
}
