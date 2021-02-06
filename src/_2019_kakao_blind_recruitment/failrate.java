package _2019_kakao_blind_recruitment;

public class failrate {
    public static void main(String[] args) {
        Solution_failrate s = new Solution_failrate();
        s.solution(4, new int[]{4,4,4,4,4});
    }
}

class Solution_failrate{
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int idx = 0;
        double[] fail_rate = new double[N+1];

        for(int i=1;i<N+1;i++){
            double working=0;
            double done=0;

            for(int j=0;j<stages.length;j++){
                if(stages[j] == i) working++;
                if(stages[j] >= i) done++;
            }

            fail_rate[i] = done > 0 ? working / done : 0;
        }

        while(idx < N) {
            Double maxv = Double.NEGATIVE_INFINITY;
            int maxidx = 0;

            for (int i = 1; i <= N; i++) {
                // 실패율 내림차순 별로 answer 넣기
                if (maxv < fail_rate[i]) {
                    maxv = fail_rate[i];
                    maxidx = i;
                }
            }

            answer[idx++] = maxidx;
            fail_rate[maxidx] = Double.NEGATIVE_INFINITY;
        }
        return answer;
    }
}
