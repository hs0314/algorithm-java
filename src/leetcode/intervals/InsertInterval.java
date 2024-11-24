package leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    /*
     * 주어진 intervals(s, e)는 start 기준 정렬되어 있고 겹치는 부분 없음
     * 새로운 newInterval을 insert하고 바뀐 intervals 출력 (오버래핑 되는건 merge)
     * 
     * 제한
     * - interval개수 0~10000 (start로 정렬)
     * - s,e는 0~100000
     * 
     * todo (interval 돌면서 하나씩 체크 O(N))
     * - 
     * - newInterval들어와도 겹치는게 없을 수 있나?
     * - 주어진 intervals는 겹치지 않기 때문에 새로운 i의 시작 이전의 것은 볼필요 없을듯
     * - i의 시작에 걸리는 interval 부터 종료까지 모두 체크하면서 걸리는 범위 정리 => 병합
     * 
     * tc
     * - 0 처리 주의
     * - newInterval에 다 포함되는 케이스
     * - newInterval도 포함이 없는 경우 (맨 앞, 맨 뒤)
     */
    public static void main(String[] args) {
        
        //insert(new int[][]{{1,5}}, new int[]{6,8});
        // insert(new int[][]{}, new int[]{2,5});
        insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        // insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        
        // s:e 형식으로 list 관리
        List<String> answerList = new ArrayList<>();
        int idx = 0;

        // 1. newInterval의 시작보다 끝이 작은 케이스 answer에 추가
        while(idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            answerList.add(String.format("%s:%s", intervals[idx][0],intervals[idx][1]));
            idx++;
        }

        // 2. merge 처리
        // newInterval 갱신
        // 앞에서 겹치지 않는 이전 interval은 다 처리했으므로 아래 조건은 걸리는 조건
        while(idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
            idx++;
        }
        answerList.add(String.format("%s:%s", newInterval[0],newInterval[1]));

        // 3. merge 처리하고 남은 in
        while(idx < intervals.length && newInterval[1] < intervals[idx][0]) {
            answerList.add(String.format("%s:%s", intervals[idx][0],intervals[idx][1]));
            idx++;
        }
        
        int[][] answerArr = new int[answerList.size()][2];
        for(int i =0;i<answerList.size();i++) {
            String answer = answerList.get(i);
            answerArr[i][0] = Integer.parseInt(answer.split(":")[0]);
            answerArr[i][1] = Integer.parseInt(answer.split(":")[1]);
        }

        return answerArr;
    }
}
