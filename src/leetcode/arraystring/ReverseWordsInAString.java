package leetcode.arraystring;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseWordsInAString {
    /*
     * string s에서 단어를 반대순서로 출력
     * - 공백문자는 싱글 space로 치환
     * 
     * 제한
     * - 문자열길이 1~10000
     * - 최소 하나의 문자가 있음
     * 
     * todo
     * - 공백은 single space로 표현하면 되므로, 단어만 식별해서 반대로 출력
     * - 순차로 읽으면서 index를 공백 아니면 push 공백이면 pop (스택사용)
     * - O(N)
     * 
     * tc
     * - 마지막 단어에 대한 처리 (공백이 없어도 마지막idx라면 substring을 s.length까지 해줘야함)
     * - 마지막 단어가 한글자라면 stack값이 비어있음
     *      " asdasd df f"
     */
    public static void main(String[] args) {
        System.out.println(reverseWords2(""));
        System.out.println(reverseWords2("a good    example"));
        System.out.println(reverseWords2("t "));
        System.out.println(reverseWords2(" asdasd df f"));
        System.out.println(reverseWords2("  hello world  "));
        

    }

    // 정규표현식 사용 처리
    public static String reverseWords2(String s) {

        s = s.trim().replaceAll("\\s+", " ");

        String[] wordArr = s.split(" ");

        StringBuffer sb = new StringBuffer();
        for (int i=wordArr.length-1;i>=0;i--) {
            sb.append(wordArr[i]);

            if(i > 0) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }

    public static String reverseWords(String s) {

        Stack<Integer> stack = new Stack<>();
        Stack<String> wordStack = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            if ((s.charAt(i) == ' ' || i == s.length()-1) && !stack.isEmpty()) {
                
                int startIdx = stack.pop();
                int endIdx = (i == s.length()-1 && s.charAt(i) != ' ') ? s.length() : i;

                wordStack.push(s.substring(startIdx, endIdx));

            } else if (s.charAt(i) != ' ' && i < s.length()-1 && stack.isEmpty()) {
                stack.push(i);
            } else if (s.charAt(i) != ' ' && i == s.length()-1 && stack.isEmpty()) {
                // 마지막 문자가 한글자(stack empty)인 케이스 처리
                wordStack.push(String.valueOf(s.charAt(i)));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!wordStack.isEmpty()) {
            sb.append(wordStack.pop());
            sb.append(" ");
        }

        return sb.deleteCharAt(sb.length()-1).toString(); // 마지막 공백 삭제
    }
}
