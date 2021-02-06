package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static void main(String[] args){
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        Solution_이중우선순위큐 s = new Solution_이중우선순위큐();

        s.solution(operations);
    }
}

class Solution_이중우선순위큐 {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int[] solution(String[] operations) {
        int[] answer = {};

        int max=-999999, min=999999;

        for(int i=0;i<operations.length;i++){
            String ops = operations[i].split(" ")[0];
            String val = operations[i].split(" ")[1];

            if("I".equals(ops)){
                pq.offer(Integer.parseInt(val));

            }else if("D".equals(ops)){
                if("1".equals(val)){
                    deleteLast();
                }else if("-1".equals(val)){
                    pq.poll();
                }
            }
        }
        while(!pq.isEmpty()){
            int v = pq.poll();
            if(max < v) max = v;
            if(min > v) min = v;
        }
        if(max == -999999) max = 0;
        if(min == 999999) min = 0;

        answer = new int[]{max,min};
        return answer;
    }

    public void deleteLast(){
        PriorityQueue<Integer> tmp = new PriorityQueue<>();

        while(pq.size() > 1){
            tmp.offer(pq.poll());
        }
        pq = tmp;
    }
}