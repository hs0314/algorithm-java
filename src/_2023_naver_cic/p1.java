package _2023_naver_cic;

import java.util.*;

public class p1 {
    public static void main (String[] args) {
        /*
        - 음수 처리
        - 모든 digit가 0인 경우 0 출력
        - **최소 10이상 상수
         */
        int N = -505;
        int maxVal = 0;

        int[] digitsDivision = new int[6]; // -999995 ~ 999995
        List<Integer> candidates = new ArrayList<>();

        // 자릿수별 분리
        for(int i=0;i<=5;i++){
            digitsDivision[i] = (int) (N % Math.pow(10,i+1) / Math.pow(10,i));
        }

        for(int i=0;i<=5;i++){
            if(digitsDivision[i] == 5 || digitsDivision[i] == -5) {
                int candidate = 0;
                int digit = 0;
                for(int j=0;j<=5;j++) {
                    if(i==j) continue;

                    candidate += digitsDivision[j] * Math.pow(10,digit);
                    digit++;
                }
                candidates.add(candidate);
            }
        }

        // max candidate 구하기
        maxVal = Collections.max(candidates);

        System.out.println(maxVal);
    }
}
