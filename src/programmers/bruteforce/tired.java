package programmers.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class tired {
    public static void main(String[] args) {
        Solution_tired s = new Solution_tired();
        s.solution(80, new int[][]{
                {80, 20}, {50, 40}, {30, 10}
        });
    }
}

class Solution_tired {

    int answer = 0;

    public int solution(int k, int[][] dungeons) {

        List<Dungeon> dungeonList = new ArrayList<>();

        for (int i = 0; i < dungeons.length; i++) {
            Dungeon d = new Dungeon(dungeons[i][0], dungeons[i][1]);
            dungeonList.add(d);
        }

        for (int i = 1; i <= dungeons.length; i++) {
            this.getPermutation(i, new ArrayList<>(), dungeonList, k);
        }

        return answer;
    }

    public void getPermutation(int pickCnt, List<Dungeon> picked, List<Dungeon> dungeonList, int k) {
        if (pickCnt == 0) {
            // 선택된 던전 순열 처리
            int possibleCnt = 0;
            for (Dungeon d : picked) {
                if (d.isPossible(k)) {
                    k = d.getRemain(k);
                    possibleCnt++;
                }
            }
            answer = Math.max(answer, possibleCnt);
            return;
        }

        for (int i = 0; i < dungeonList.size(); i++) {
            // 현재 던전을 선택
            Dungeon dungeon = dungeonList.get(i);

            // 선택한 던전을 제외한 나머지 리스트 생성
            List<Dungeon> remaining = new ArrayList<>(dungeonList);
            remaining.remove(i);

            // 현재 선택한 던전을 추가한 리스트 생성
            List<Dungeon> newPicked = new ArrayList<>(picked);
            newPicked.add(dungeon);

            getPermutation(pickCnt - 1, newPicked, remaining, k);
        }
    }

    static class Dungeon {
        private int need;
        private int willUse;

        public Dungeon(int need, int willUse) {
            this.need = need;
            this.willUse = willUse;
        }

        public boolean isPossible(int k) {
            return k >= this.need;
        }

        public int getRemain(int k) {
            return k - this.willUse;
        }
    }
}