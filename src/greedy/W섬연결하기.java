package greedy;

import java.util.Arrays;

public class W섬연결하기 {

    public static void main(String[] args) {
        Solution_섬연결하기 s = new Solution_섬연결하기();
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        s.solution(4, costs);
    }
}

class Solution_섬연결하기{

    public int solution(int n, int[][] costs) {
        int[][] map = new int[n][n];
        int[][] minMap = new int[n][n];
        int answer = Integer.MAX_VALUE;

        for(int i=0;i<costs.length;i++){
            map[costs[i][0]][costs[i][1]] = costs[i][2];
            map[costs[i][1]][costs[i][0]] = costs[i][2];
        }

        /*
         여기서 각 cur -> desti 로 가는 최소값에 대한 계산을 구해놓는다.
         */
        for(int i=0;i<n;i++){
           int cur = i;

        }



        for(int i=0;i<n;i++){
            int linkedCnt = 1;
            int cur = i;
            boolean[] checked = new boolean[n];
            answer = 0;

            while(linkedCnt < n){

                int nextIdx = 0;
                int nextMinCost=Integer.MAX_VALUE;
                for(int j=0;j<n;j++){
                    if(map[cur][j] == 0){
                        continue;
                    }
                    if( nextMinCost > map[cur][j]){
                        nextIdx = j;
                        nextMinCost = map[cur][j];
                    }
                }
                if(!checked[cur]) {
                    checked[cur] = true;
                    linkedCnt++;
                }
                cur = nextIdx;
                answer += nextMinCost;
            }
        }

        return answer;
    }
}

