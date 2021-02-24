package _2018_kakao_blind_recruitment;

import java.util.ArrayList;
import java.util.List;

public class compression {
    public static void main(String[] args) {
        Solution_compression s = new Solution_compression();
        s.solution("TOBEORNOTTOBEORTOBEORNOT");
    }
}
/*
 ? map 사용, list사용 -> idx출력,, 리스트

 글자별로 보면서 map 에 들어가있는지 체크
 X -> 해당 글자 map에 추가
 */
class Solution_compression{
    public int[] solution(String msg) {
        List<Integer> answerList = new ArrayList<>();
        List<String> dict = new ArrayList<>();

        // A~Z 까지 셋팅
        for(char c = 'A';c<='Z';c++){
            dict.add(String.valueOf(c));
        }

        int startIdx = 0;
        int endIdx = startIdx+1;

        while(startIdx < msg.length()){
            // msg 길이만큼 돌면서 dict에 포함되는 최대 길이 partial 구하기
            String partial = msg.substring(startIdx, endIdx);

            // 포함하면
            if(dict.contains(partial) && endIdx < msg.length()){
                endIdx++;
            }else{
                // endIdx포함 이전 partial의 색인번호 출력
                // 마지막 idx의 경우 처리를 위해서 삼항으로 체크
                String targetPartial = partial.substring(0, dict.contains(partial) ? partial.length() : partial.length()-1);
                answerList.add(dict.indexOf(targetPartial)+1); // idx 0부터 시작하기 때문에 1씩 더해줌

                // endIdx포함 partial을 사전추가
                dict.add(partial);

                startIdx += targetPartial.length();
            }
        }

        // ArrayList- > int array
        int[] answer = new int[answerList.size()];
        int idx = 0;
        for(int i : answerList){
            answer[idx++] = i;
        }

        return answer;
    }
}
