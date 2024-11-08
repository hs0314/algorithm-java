package programmers.bp;

public class 카펫 {
    public static void main (String[] args) {
        int brown=24;
        int yellow=24;
        int totalCnt = brown+yellow;
        int[] answer = new int[2];

        for(int x=3;x<=totalCnt/3;x++){
            if(totalCnt % x > 0 || totalCnt/x > x) continue;

            int y= totalCnt / x;
            int outerCnt = (x*2)+(y*2)-4;

            if(totalCnt - outerCnt == yellow){
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }
        System.out.println(answer);
    }
}
