package hash;

import java.util.HashMap;
import java.util.Map;

/*
**기본적인 HashMap 사용용례
- 정렬되어 있지 않음.
- 검색 속도가 빠름
- 크기가 작은 데이터를 핸들링할때 hashMap을 사용하면.. 괜히 메모리 사용 비효율

피드백
- HashMap의 getOrDefault() 메서드 참고
- replace 메서드 쓸 필요없이 put 새로하는 것, 어떤 것이 더 효율적인가?
-
 */

public class 완주하지못한선수 {

    public static void main (String[] args){
        String[] participant = {"a","b","c"};
        String[] completion={"b","c"};

        String answer = "";
        int psize = participant.length;
        Map<String, Integer> mapObj = new HashMap<String, Integer>();

        //initial setting
        for(int i=0;i<psize;i++){

            if(mapObj.get(participant[i]) != null) {
                int curVal = mapObj.get(participant[i]);
                mapObj.replace(participant[i], curVal + 1);
            }else{
                mapObj.put(participant[i], 1);
            }
        }

        for(int i=0;i<psize-1;i++){
            int curVal = mapObj.get(completion[i]);
            mapObj.replace(completion[i], curVal-1);
        }

        for( String key : mapObj.keySet() ){
            if(mapObj.get(key) > 0){
                answer = key;
                break;
            }
        }
        System.out.println(answer);
        //return answer;
    }
}


/*
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
 */
