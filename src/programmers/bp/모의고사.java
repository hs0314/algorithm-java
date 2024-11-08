package programmers.bp;

import java.util.ArrayList;

public class 모의고사 {
    public static void main (String[] args) {
        int[] answers = {1,3,2,4,2};

        int maxVal = 0;
        int[][] pattern = {
                  {1,2,3,4,5}
                , {2,1,2,3,2,4,2,5}
                , {3,3,1,1,2,2,4,4,5,5}
        };
        int[] cnt = {0,0,0};

        for(int i=0;i<answers.length;i++){
            for(int j=0;j<3;j++){
                int idx = i % (pattern[j].length);

                if(pattern[j][idx] == answers[i]){
                    cnt[j]++;
                    if(cnt[j] > maxVal) maxVal = cnt[j];
                }
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();

        int[] answer;
        for(int i=0;i<3;i++){
            if(maxVal == cnt[i]) answerList.add(i+1);
        }
        answer = new int[answerList.size()];
        int idx = 0;
        for(Integer val : answerList){
            answer[idx++] = val;
        }
        System.out.println("");
    }
}
