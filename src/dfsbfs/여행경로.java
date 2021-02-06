package dfsbfs;

import java.util.*;

public class 여행경로 {
    public static void main(String[] args){

        Solution_여행경로 s = new Solution_여행경로();

        //String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets ={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        //String[][] tickets = {{"ICN", "SFO"}, {"ICN", "SFO"}, {"SFO", "ICN"}};

        //String[][] tickets = {{"ICN","BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"} ,{"DOO", "BOO"}, {"BOO","ICN"}, {"COO", "BOO"}};
        //String[][] tickets = {{"ICN","A"}, {"A","B"}, {"B","A"}, {"A","ICN"}, {"ICN","A"} };
        //String[][] tickets = {{"ICN","A"}, {"ICN","B"}, {"B","ICN"} };
        s.solution(tickets);

    }
}

class Solution_여행경로 {
    HashMap<String, ArrayList<String>> mapObj = new HashMap<>();
    boolean getAnswer = false;
    String[] realAnswer;

    public String[] solution(String[][] tickets) {
        TreeMap<String, Integer> tickedUsedChk = new TreeMap<>();

        for(int i=0;i<tickets.length;i++){
            if(mapObj.get(tickets[i][0]) != null ){
                mapObj.get(tickets[i][0]).add(tickets[i][1]);
            }else {
                ArrayList<String> tmpList = new ArrayList<>();
                tmpList.add(tickets[i][1]);
                mapObj.put(tickets[i][0], tmpList);
            }
            tickedUsedChk.put(tickets[i][0]+":"+tickets[i][1], tickedUsedChk.getOrDefault(tickets[i][0]+":"+tickets[i][1],0) + 1);
        }
        String[] answer = new String[tickets.length+1];

        TreeMap<String, Integer> cloneTickedUsedChk = (TreeMap<String, Integer>) tickedUsedChk.clone();

        dfs("ICN", cloneTickedUsedChk, answer, 0);

        return answer;
    }

    public void dfs(String curCity,
                    TreeMap<String, Integer> tickedUsedChk,
                    String[] answer,
                    int curIdx){

        answer[curIdx] = curCity;
        if(getAnswer) return;
        if(chkFunc(tickedUsedChk, answer, tickedUsedChk.size()+1) && !getAnswer ){
            getAnswer = true;
            realAnswer = answer.clone();
            return;
        }

        // 정렬
        Iterator<String> iteratorKey = tickedUsedChk.keySet().iterator(); // key값에 대한 오름차순
        while(iteratorKey.hasNext()){
            String key = iteratorKey.next();
            String start = key.split(":")[0];
            String destination = key.split(":")[1];

            // 현재 도시X && 다음 도시에 방문가능 여부 체크
            if(curCity.equals(start) && mapObj.get(curCity) != null && mapObj.get(curCity).contains(destination)){
                String nextCity = destination;

                if(tickedUsedChk.get(curCity+":"+destination) > 0) {
                    tickedUsedChk.put(curCity+":"+destination, tickedUsedChk.get(curCity+":"+destination) - 1);
                    curIdx++;
                    dfs(nextCity,tickedUsedChk, answer, curIdx);
                    curIdx--;
                    tickedUsedChk.put(curCity+":"+destination, tickedUsedChk.get(curCity+":"+destination) + 1);
                }
            }
        }
    }

    private boolean chkFunc(TreeMap<String, Integer> tickedUsedChk, String[] answer, int answerCnt){
        for(String key : tickedUsedChk.keySet()){
            if(tickedUsedChk.get(key).intValue() > 0) return false;
        }

        for(int i=0;i<answerCnt;i++){
            if(answer[i] == null || "".equals(answer[i])) return false;
        }

        return true;
    }
}

