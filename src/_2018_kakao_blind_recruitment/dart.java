package _2018_kakao_blind_recruitment;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class dart {
    public static void main(String[] args) {
        Solution_dart s = new Solution_dart();
        s.solution("1D2S#10S");
    }
}

class Solution_dart{
    Map<String, Integer> bonusMap = Stream.of(new Object[][] {
            { "S", 1 },
            { "D", 2 },
            { "T", 3 },
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

    int[] score = new int[3];
    int scoreCnt = 0;

    public int solution(String dartResult) {
        int answer = 0;
        /*
        S, D, T -> 거듭제곱
        * -> 해당점수, 이전점수를 2배 (중첩가능)
        # -> 해당점수 마이너스 (*와 중첩가능)
        * #는 각 기회별 존재하지 않을수도 있음
         */
        String num = "";
        String bonus = "";
        String option = "";

        boolean getBonus = false;
        for(int i=0;i<dartResult.length();i++){
            Character cur = dartResult.charAt(i);

            if(cur >= '0' && cur <= '9'){
                if(getBonus){ // bonus까지 입력받은 상태면 이전 라운드 점수 계산
                    calc(num, bonus, option);
                    getBonus = false;
                    num = "";
                    bonus = "";
                    option = "";
                }

                num += cur.toString();
            }else if(cur == 'S' || cur == 'D' || cur =='T'){
                bonus = cur.toString();
                getBonus = true;
            }else if(cur == '#' || cur == '*'){
                option = cur.toString();
            }

            if(i == dartResult.length()-1){ // 마지막 라운드(3) 계산 처리
                calc(num, bonus, option);
            }
        }

        return score[0] + score[1] + score[2];
    }
    void calc(String num, String bonus, String option){
        int number = Integer.parseInt(num);
        int exp = bonusMap.get(bonus);

        if("#".equals(option)){
            score[scoreCnt++] = (int)Math.pow(number, exp) * -1;
        }else if("*".equals(option)){
            score[scoreCnt] = (int)Math.pow(number, exp) * 2;
            if(scoreCnt > 0){
                score[scoreCnt-1] = score[scoreCnt-1] * 2;
            }
            scoreCnt++;
        }else{
            score[scoreCnt++] = (int)Math.pow(number, exp);
        }
    }
}
