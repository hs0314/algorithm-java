package programmers._2022_kakao_internship;

import java.util.*;

public class personality {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5,3,2,7,5});
    }
}

class Solution{
    // 지표별 점수 map
    // 1 ~ 7
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] critnList = new String[]{"RT","CF","JM","AN"};
        Map<String, Integer> scoreMap = new HashMap<>();

        for(int i=0;i<survey.length;i++){
            String pros = String.valueOf(survey[i].charAt(0));
            String cons = String.valueOf(survey[i].charAt(1));

            if(choices[i] < 4) {
                int currentScore = scoreMap.getOrDefault(pros, 0);
                currentScore += (4 - choices[i]);
                scoreMap.put(pros, currentScore);
            } else if(choices[i] > 4) {
                int currentScore = scoreMap.getOrDefault(cons, 0);
                currentScore += Math.abs(4 - choices[i]);
                scoreMap.put(cons, currentScore);
            }
        }

        List<Map.Entry<String,Integer>> scoreList = new ArrayList<>(scoreMap.entrySet());
        scoreList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int scoreCompare = o2.getValue().compareTo(o1.getValue());
                if (scoreCompare == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return scoreCompare;
            }
        });

        for (String critn : critnList) {

            boolean added = false;
            for (Map.Entry<String,Integer> score : scoreList) {
                if (critn.contains(score.getKey())) {
                    answer += score.getKey();
                    added = true;
                    break;
                }
            }

            if (!added) {
                answer += String.valueOf(critn.charAt(0));
            }
        }

        return answer;
    }
}