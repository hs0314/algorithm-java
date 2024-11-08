package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
    public static void main (String[] args) {
        boolean answer = true;
        String[] phone_book = {"011", "52", "0123", "44"};
        Map<String, Integer> mapObj = new HashMap<String, Integer>();

        Arrays.sort(phone_book);

        for(String num : phone_book) {
            int numLen = num.length();

            for (int i = 0; i < numLen; i++) {
                String key = num.substring(0, i+1);
                mapObj.put(key, mapObj.getOrDefault(key, 0) + 1);
            }
        }
        for( String key : phone_book ){
            if(mapObj.get(key) > 1){
                answer = false;
                break;
            }
        }
        System.out.println(answer);
    }
}
