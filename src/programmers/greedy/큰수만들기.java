package programmers.greedy;

public class 큰수만들기 {
    public static void main(String[] args) {
        Solution_큰수만들기 s = new Solution_큰수만들기();

        s.solution("4177252841",4);
    }
}


class Solution_큰수만들기 {
    /* greedy임에 유념해서 각 선택에서 최선을 택한다 */
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int numLen = number.length();
        int answerLen = numLen - k;
        int startIdx = 0;

        while (true) {
            char maxChar = '0';
            for(int i=startIdx;i<numLen-answerLen+answer.length()+1;i++){
                if(number.charAt(i) == '9'){
                    maxChar = '9';
                    startIdx = i+1;
                    break;
                }

                if(maxChar < number.charAt(i)){
                    maxChar = number.charAt(i);
                    startIdx = i+1;
                }

            }
            answer.append(maxChar);
            if(answer.length() == answerLen) break;
        }

        return answer.toString();
    }

    /* 아래 풀이는 전체 조합을 구하기 때문에 O(N)풀이가 불가능하다.

    boolean[] selected = new boolean[1000001];
        StringBuilder max = new StringBuilder("0");

        public String solution(String number, int k) {
            String answer = "";
            int startIdx = 0;
            char maxChar = '0';

            //num 시작 idx 체크
            for(int i=0;i<number.length()-k;i++){
                char tmpChar = number.charAt(i);
                if(maxChar < tmpChar){
                    startIdx = i;
                    maxChar = tmpChar;
                }
            }
            generateNum(number, new StringBuilder(), number.length() - k, startIdx);

            return max.toString();
        }

        //TODO; 굳이 idx 0부터 볼필요없이 targetLen 이전 str부터 확인해서 max 인 idx부터 확인한다.
        public void generateNum(String number, StringBuilder generatedStr, int targetLength, int curIdx){
            //idx0이 "0"이 아닌 케이스만 찾도록 한다.

            if(generatedStr.length() == targetLength) {
                if (max.compareTo(generatedStr) < 0) max = generatedStr;

                return;
            }

            for(int i=curIdx;i<number.length();i++) {
                if(selected[i] || (generatedStr.length() == 0 && number.charAt(i) == '0' )) continue;

                selected[i] = true;
                generatedStr.append(number.charAt(i));
                generateNum(number, generatedStr, targetLength, i);
                selected[i] = false;
                generatedStr = (generatedStr.length() > 0) ? generatedStr.deleteCharAt(generatedStr.length()-1) : generatedStr;
            }
    }
     */
}