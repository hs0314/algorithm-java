package programmers._2021_kakao_blind_recruitment;

import java.util.*;

public class renewal {
    public static void main(String[] args) {
        Solution_renewal s = new Solution_renewal();
        s.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4});
    }
}
class Solution_renewal{

    HashMap<String, Integer> menuMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answerList = new ArrayList<>();
        /*
         코스는 최소 2가지 이상 메뉴
         최소 2명 이상의 손님이 주문한 단품메뉴조합 -> 코스요리 메뉴 후보

         orders -> 손님별 주문 단품
         course -> 스카피가 원하는 코스별 단품요리개수

         메뉴 구성을 알파벳 오름차순

         */

        int[] courseMax = new int[11]; // course크기 1~10

        // 각 메뉴별 최소 2개이상의 값을 코스요리 메뉴 후보로 셋팅
        for(String menu : orders){

            for(int r=2;r<=menu.length();r++) {   // 메뉴개수
                combination(menu, new char[r], menu.length(), r, 0, 0);
            }
        }

        // 코스길이별 최대 order 횟수 계산
        for(String key : menuMap.keySet()){
            if(courseMax[key.length()] < menuMap.get(key)){
                courseMax[key.length()] = menuMap.get(key);
            }
        }

        // 코스별로 maxVal을 코스요리 메뉴후보로 넣는다
        for(int ci = 0;ci<course.length;ci++){
            int courseMaxLen = courseMax[ course[ci] ]; // 스카피가 원하는 코스단품개수별 max order값

            for(String key : menuMap.keySet()){
                if(key.length() == course[ci] && menuMap.get(key) == courseMaxLen && menuMap.get(key) > 1){
                    answerList.add(key);
                }
            }
        }

        String[] answer = new String[answerList.size()];
        int answerIdx=  0;
        for(String s : answerList){
            answer[answerIdx++] = s;
        }

        Arrays.sort(answer);

        return answer;
    }

    void combination(String str, char[] selected, int n, int r, int index, int target) {
        if(r==0){
            //selected를 가지고 조합을 구하고 있으므로 sort를 해버리면 꼬이기 때문에 clone으로 아예 새로운 객체로 가져오도록 한다.
            char[] tmpChar = selected.clone();
            Arrays.sort(tmpChar);

            String selectedStr="";
            for(int i=0;i<index;i++){
                selectedStr+=tmpChar[i];
            }
            menuMap.put(selectedStr, menuMap.getOrDefault(selectedStr, 0) + 1);

            return;
        }
        if(target == n) return;

        selected[index] = str.charAt(target);
        combination(str, selected, n, r-1, index+1, target+1); //뽑는 경우
        selected[index] = 0;
        combination(str, selected, n, r, index, target+1); //안 뽑는 경우
    }
}