package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class MergeIntervals {
    /*
     * 범위가 겹치는 interval을 merge하고 최종적으로 남은 겹치지 않는 intervals 출력
     * 
     * 제한
     * - 주어지는 범위 개수 1~10000
     * - start,end는 0~10000
     * 
     * todo
     * - int 2차원배열을 x->y 순서로 정렬필요
     * - 배열 정렬 후, loop o(N) 돌면서 같은 범위에 포함되는 대상을 다 찾아서 merged interval계산
     * - merge시 생길 수 있는 케이스 정리
     *      이전 interval이 이후 interval을 포함해버리는 경우
     *      이전 interval 끝 = 이후 interval 시작
     */
    public static void main(String[] args) {

        //int[][] inp0 = { { 0, 0 } };
        int[][] inp0 = {
            { 1,3 },
            { 2,6 },
            { 8,10 },
            { 15,18 }
        };
        int[][] inp1 = { { 1, 10 }, { 4, 5 }, { 6, 7 }, { 2, 3 } };
        int[][] inp2 = { { 1, 4 }, { 4, 5 } };

        //System.out.println(merge(inp0));
        System.out.println(merge(inp1));
        System.out.println(merge(inp2));
    }

    public static int[][] merge(int[][] intervals) {

        // "시작:종료" 포맷 string list
        List<int[]> answerList = new ArrayList<>();

        // [0][0] 0시작 / [0][1] 0종료
        // 정렬
        Arrays.sort(intervals, (a1,a2) -> {
            if (a1[0] == a2[0]) {
                return a1[1] - a2[1];
            }
            return a1[0] - a2[0];
        });

        int startIdx = 0;
        int maxEnd = intervals[0][1];

        for(int i=1;i<intervals.length;i++) {

            // 머징 불가 조건 (이전 인터벌의 종료가 이후 인터벌 시작보다 작은 경우)
            // - 시작은 건드릴 필요 없음
            if (maxEnd < intervals[i][0]) {

                answerList.add(new int[]{intervals[startIdx][0], maxEnd});

                // 현재부터 다시 머징 시작
                startIdx = i;
            }

            maxEnd = Math.max(maxEnd, intervals[i][1]);
        }

        // 마지막 idx 처리
        answerList.add(new int[]{intervals[startIdx][0], maxEnd});

        return answerList.toArray(new int[answerList.size()][2]);
    }
}
