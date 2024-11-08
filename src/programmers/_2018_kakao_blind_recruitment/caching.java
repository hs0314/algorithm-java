package programmers._2018_kakao_blind_recruitment;

import java.util.*;

public class caching {
    public static void main(String[] args) {
        Solution_caching s = new Solution_caching();
        s.solution(0, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"});
    }
}

class Solution_caching{
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        Set<String> cacheKey = new HashSet<>();
        /*
        LRU -> queue
        hit -> 1 , miss ->5
        ***대소문자처리
         */

        for(String city : cities){
            //대소문자 통일
            city = city.toUpperCase();

            // 캐싱여부 확인
            if(cacheSize > 0 && cacheKey.contains(city)){
                answer += 1;
                q.remove(city);
                q.offer(city);
            }else{
                answer += 5;

                // 캐싱 LRU 교체
                if(cacheSize == q.size()) {
                    String removeKey = q.poll();
                    cacheKey.remove(removeKey);
                }
                q.offer(city);
                cacheKey.add(city);
            }
        }

        return answer;
    }
}