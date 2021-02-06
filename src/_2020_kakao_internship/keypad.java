package _2020_kakao_internship;

import static java.lang.Math.abs;

/**
 * 2020 키패드 누르기
 */



class keypad{
    public static void main(String[] args) {
        solution( new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
    }

    //solution
    public static String solution(int[] numbers, String hand){
        // target num 좌표 -> (x % 3 , x / 3)
        /*
         1, 4, 7 -> L
         3, 6, 9 -> R
         2, 5, 8, 0 -> 좌우 엄지에서 타겟 거리 판단 -> 같으면 hand 참고
         */

        StringBuilder answer = new StringBuilder();
        int curLeft = 10; // *
        int curRight= 12; // #

        for(int i=0;i<numbers.length;i++) {
            if(numbers[i] == 0) numbers[i] = 11;

            if(numbers[i] != 11 && numbers[i] % 3 == 1){
                answer.append("L");
                curLeft = numbers[i];
            }else if(numbers[i] != 11 && numbers[i] % 3 == 0){
                answer.append("R");
                curRight = numbers[i];
            }else{
                int lDist = getDist(curLeft, numbers[i]);
                int rDist = getDist(curRight, numbers[i]);

                if(lDist > rDist || (lDist == rDist && "right".equals(hand))){
                    answer.append("R");
                    curRight = numbers[i];
                }
                else if(lDist < rDist || (lDist == rDist && "left".equals(hand))){
                    answer.append("L");
                    curLeft = numbers[i];
                }
            }
        }

        return answer.toString();
    }

    public static int getDist(int cur, int target){
        int curX = (cur-1) % 3;
        int curY = (cur-1) / 3;
        int targetX = (target-1) % 3;
        int targetY = (target-1) / 3;

        return abs(targetX - curX) + abs(targetY - curY);
    }


}