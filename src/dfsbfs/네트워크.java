package dfsbfs;

public class 네트워크 {
    public static void main (String[] args) {
        int n=3;
        int[][] computers ={{1,1,0},{1,1,0},{0,0,1}};
        //int[][] computers ={{1,1,0},{1,1,1},{0,1,1}};

        Solution s = new Solution();
        s.solution(n, computers);
    }
}


class Solution {
    int[] visit = new int[10];
    int answer = 0;

    public int solution(int n, int[][] computers){

        //Queue<Integer> q = new LinkedList<>();

        //bfs(q, n, computers, 0); // queue, start
        for(int i=0;i<n;i++){
            if(visit[i] == 0) answer++;
            dfs(i, n, computers);
        }
        System.out.println(answer);
        return answer;
    }
    public void dfs(int cur, int n, int[][]computers){
        visit[cur] = 1;
        for(int i=0;i<n;i++){
            if(computers[cur][i] == 1 && cur != i) {
                int next = i;
                if (visit[next] == 0) {
                    dfs(next, n, computers);
                }
            }
        }
    }
    /*
    public void bfs(Queue<Integer> q, int n, int[][]computers, int start){
        q.offer(start);
        visit[start] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=0;i<n;i++){
                if(computers[cur][i] == 1 && cur != i) {
                    int next = i;

                    if (visit[next] == 0) {
                        q.offer(next);
                    }
                    visit[next] ++;
                }
            }
        }
    }
     */
}
