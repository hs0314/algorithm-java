package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    /*
    map의 상태 기준으로 목적지 최단거리, 갈 수 없으면 -1

    constraints
    - n*m (n,m은  1~100)
    - 1,1 => n,m 이동 (2차배열 특성상 시작==끝 일수는 없음)

     */
    public static void main (String[] args) {

        int[][] maps1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int[][] maps2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        Solution s = new Solution();
        s.solution(maps1);
        s.solution(maps2);
    }
    static class Solution {

        //상하좌우 움직임
        final int[] dx={1,0,-1,0};
        final int[] dy={0,1,0,-1};
        public int solution(int[][] maps) {
            final int mapy = maps.length;
            final int mapx = maps[0].length;

            // 이미 지나온곳을 돌아가지 못하게 visit여부 체크
            // xxx: 이거 필요없이 현재 지나온거리 distance를 이전 distance+1로 계속 누적해나가면 maps 내에서 해결가능
            //boolean[][] isVisited = new boolean[mapy+1][mapx+1];

            Queue<Coord> queue = new LinkedList<>();

            // 가중치 없고, 최단거리 => BFS
            queue.add(new Coord(0,0));

            while (!queue.isEmpty()) {

                // 한 사이클
                Coord cur = queue.poll();
                if (cur.x == mapx - 1 && cur.y == mapy - 1) {
                    break;
                }

                // 다음 갈 수 있는 경로 queue add
                for (int i = 0; i < 4; i++) {
                    if (cur.x + dx[i] >= 0 && cur.x + dx[i] < mapx && cur.y + dy[i] >= 0 && cur.y + dy[i] < mapy) {
                        if (maps[cur.y + dy[i]][cur.x + dx[i]] == 1) {
                            queue.add(new Coord(cur.x + dx[i], cur.y + dy[i]));
                            maps[cur.y + dy[i]][cur.x + dx[i]] = maps[cur.y][cur.x] + 1; // distance 체크
                        }
                    }
                }
            }

            // chk : map사이즈가 1인 경우는?
            return maps[mapy-1][mapx-1] == 1 ? -1 : maps[mapy-1][mapx-1];
        }
    }
    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
