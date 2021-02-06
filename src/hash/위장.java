package hash;

import java.util.HashMap;

public class 위장 {
    public static void main (String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int answer = 1;
        HashMap<String, Integer> mapObj = new HashMap<>();

        for(int i=0;i<clothes.length;i++){
            mapObj.put(clothes[i][1], mapObj.getOrDefault(clothes[i][1], 0) + 1);
        }

        for( String key : mapObj.keySet() ){
            // 의상의 대한 선택권 = 전체 의상 수 + 1 (선택X)
            answer *= (mapObj.get(key) + 1);
        }
        System.out.println(answer -1);
    }
}
