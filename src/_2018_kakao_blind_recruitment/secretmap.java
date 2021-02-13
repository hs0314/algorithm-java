package _2018_kakao_blind_recruitment;

public class secretmap {
    public static void main(String[] args) {
        Solution_secretmap s = new Solution_secretmap();

        s.solution(5, new int[]{9,20,28,18,11}, new int[]{30,1,21,17,28});
    }
}

class Solution_secretmap{
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        /*
         row별로 10->2진수 변경 , and연산 결과를 answer에 추가
         */
        for(int i=0;i<n;i++){
            String binary1 = convertToBinary(n-1, arr1[i]);
            String binary2 = convertToBinary(n-1, arr2[i]);
            StringBuilder result = new StringBuilder();

            for(int j=0;j<n;j++){
                // 겹침 체크
                boolean flag = binary1.charAt(j) == '1' || binary2.charAt(j) == '1';
                if(flag){
                    result.append("#");
                }else{
                    result.append(" ");
                }
            }

            answer[i] = result.toString();
            result.setLength(0);
        }

        return answer;
    }

    public String convertToBinary(int n, int num){
        StringBuilder binary = new StringBuilder();

        while(n >= 0){
            if(num / (int)Math.pow(2,n) > 0) {
                binary.append(num / (int) Math.pow(2, n));

                num -= Math.pow(2, n);
            }else{
                binary.append(0);
            }
            n--;
        }

        return binary.toString();
    }
}
