package _2021_kakao_blind_recruitment;

import java.util.Locale;

public class recommandation {
    public static void main(String[] args) {
        Solution_recommandation s = new Solution_recommandation();
        s.solution("=.=");
    }
}

class Solution_recommandation{
    public String solution(String new_id) {
        String answer = "";
        /*
         id length 3~15
         -> 소문자, -, _, . (마침표는 처음과끝 X, 연속 X)
         */

        // 1. 대 -> 소문자 치환
        answer = new_id.toLowerCase();

        // 2.
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<answer.length();i++){
            char c = answer.charAt(i);
            // 2.
            if( (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')|| c == '-' || c == '_' || c == '.'){
                sb.append(c);
            }
        }
        answer = sb.toString();
        sb.setLength(0);

        // 3.
        char prev_c = 0;
        for(int i=0;i<answer.length();i++){
            char c = answer.charAt(i);
            if(c == '.' && prev_c == c){
                prev_c = c;
                continue;
            }
            sb.append(c);
            prev_c = c;
        }
        answer = sb.toString();

        // 4. 처리하다가 answer이 빈문자열이 되어서 에러 발생할 수 있음
        if (!answer.isBlank() && answer.charAt(0) == '.') answer = answer.substring(1, answer.length());
        if (!answer.isBlank() && answer.charAt(answer.length() - 1) == '.') answer = answer.substring(0, answer.length() - 1);

        if(answer.isBlank()) {
            // 5.
            if (answer.isBlank()) {
                answer = "a";
            }
        }
        // 6.
        if(answer.length() > 15){
            answer = answer.substring(0, 15);
            if(answer.charAt(14) == '.'){
                answer = answer.substring(0, 14);
            }
        }

        if(answer.length() <= 2){
            String lastChar = answer.charAt(answer.length()-1) + "";
            while(answer.length() < 3){
                answer+=lastChar;
            }
        }

        return answer;
    }
}
