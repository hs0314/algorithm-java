package leetcode.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
    
        /*
         - 예약어
            - . 현재
            - .. 이전
            - / (=// , ///)
        - 규칙
            - 무조건 /로 시작
            - root가 아니면 /로 끝나면 안됌
            - 무조건 single /

        - constraint
            - tc는 항상 valid path로 나옴
            - 1 <= len <= 3000

        - 하나씩 읽으면서 예약어는 stack에 넣고 처리..?
        - replace //, /// -> /
        
        - tc
            - 루트인데 계속 이전처리
         */

         String path = "/.../a/../b/c/../d/./";
         Stack<String> stack = new Stack<>();

         String[] splitedPath = path.split("/");

         for (String s : splitedPath) {
            if ("".equals(s) || ".".equals(s)) {
                continue;
            } else if("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
         }

         String simplifyPath = "/" + String.join("/", stack);

         System.out.println(simplifyPath);
    }
    
}
