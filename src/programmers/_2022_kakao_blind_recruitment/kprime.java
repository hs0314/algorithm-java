package programmers._2022_kakao_blind_recruitment;

public class kprime {
    public static void main(String[] args) {
        Solution_kprime s = new Solution_kprime();
        s.solution(3, 3);
    }
}

class Solution_kprime {
    public int solution(int n, int k) {
        /*
        n -> k 진수
        n,k input봤을때 이건 직접 진수변환하고 특정 조건 마다 소수 세면 될듯
        백만 -> 3진수 변환해도 13자리 (이러면 int 범위 넘어섬)
         */
        int answer = 0;

        String convertedN = Integer.toString(n, k);

        for(int i=0;i<convertedN.length();i++) {
            for (int j = i+1; j < convertedN.length()+1; j++) {

                String target = convertedN.substring(i, j);
                boolean isStartIdx = (i == 0);
                boolean isEndIdx = (j == convertedN.length());

                if(isPrime(target, isStartIdx, isEndIdx)){
                    answer++;
                }
            }
        }
        return answer;
    }

    public boolean isPrime(String target, boolean isStartIdx, boolean isEndIdx){
        boolean isPrimeCheckable = false;

        if(target.charAt(0) == '0' && target.charAt(target.length()-1) == '0' && target.length() > 2) {
            target = target.substring(1,target.length()-1);
            isPrimeCheckable = true;
        } else if(isStartIdx && target.charAt(target.length()-1) == '0' && target.length() > 1){
            target = target.substring(0,target.length()-1);
            isPrimeCheckable = true;
        } else if(isEndIdx && target.charAt(0) == '0' && target.length() > 1){
            target = target.substring(1,target.length());
            isPrimeCheckable = true;
        } else if(isStartIdx && isEndIdx){
            isPrimeCheckable = true;
        }

        if(isPrimeCheckable) {
            if(target.contains("0") || "1".equals(target)) {
                return false;
            }
            long targetNumber = Long.parseLong(target);

            // 2부터 number의 제곱근까지 나누어떨어지는지 확인
            for (int i = 2; i <= Math.sqrt(targetNumber); i++) {
                if (targetNumber % i == 0) {
                    return false;  // 나누어떨어지면 소수가 아님
                }
            }
            return true;
        }

        return false;
    }
}