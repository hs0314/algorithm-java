package programmers._2018_kakao_blind_recruitment;

public class Nnumber {
    public static void main(String[] args) {
        Solution_Nnumber s = new Solution_Nnumber();
        s.solution(16,16,2,2);
    }
}

class Solution_Nnumber{
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        int targetLen = m * t + p;
        /*
        10-15 A-F로 변환
        0부터 몇까지 진수변환을 할것인지?
        t <= 1000 (말하는개수)
        m <= 100 (사람수)
        p (차례)
        */

        // 답을 얻을 수 있는 길이까지 String 붙이기 (가능한가?)
        while(true){
            if(sb.length() >= targetLen){
                break;
            }
            sb.append(this.convert(cur, n));
            cur++;
        }

        // 0번째 idx부터 보기 위해서 (p-1) 부터 시작
        for(int i=p-1;i<(m*t+(p-1));i+=m){
            answer.append( sb.charAt(i) );
        }

        return answer.toString();
    }

    public String convert(int cur, int n){
        // cur를 특정 진법으로 변환
        StringBuilder sb = new StringBuilder();

        int exp = 1;

        // 현재 cur을 넘지않는 최대 exp 구하기
        while(Math.pow(n, exp) <= cur){
            exp++;
        }
        for(int i=exp-1;i>=0;i--){
            int divideNum = (int)Math.pow(n,i);

            // n진수 숫자 변환마다 10이상 숫자에 대한 처리
            sb.append( setNum(cur / divideNum) );
            cur = cur % divideNum;
        }

        return sb.toString();
    }

    private String setNum(int n){
        if(n>=10){
            return String.valueOf((char)('A'+(n-10)));

        }else{
            return String.valueOf(n);
        }
    }
}
