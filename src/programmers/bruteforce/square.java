package programmers.bruteforce;

public class square {
    public static void main(String[] args) {
        Solution_square s = new Solution_square();
        s.solution(new int[][]{
                {60, 50}, {30, 70}, {60, 30}, {80, 40}
        });
    }
}

class Solution_square {
    public int solution(int[][] sizes) {
        /*
         - w,h중 큰 값의 max, w,h중 작은값의 max을 구하면 모든 명함 커버 가능
         */
        int maxLenMax = -1;
        int minLenMax = -1;

        for (int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);

            if (maxLenMax < max) {
                maxLenMax = max;
            }
            if (minLenMax < min) {
                minLenMax = min;
            }
        }
        return maxLenMax * minLenMax;
    }
}