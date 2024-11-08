package programmers.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args){
        Solution_다리를지나는트럭 s = new Solution_다리를지나는트럭();

        //int[] truck_weights = {7,4,5,6};
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(s.solution(100, 100, truck_weights));
    }
}

class Solution_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] truck_times = new int[truck_weights.length];
        int curIdx = 0;

        while(true){
            int curWeight = 0;

            //현재 올라와있는 트럭의 무게 총합
            for(int i=0;i<curIdx;i++){
                if(truck_times[i] < bridge_length) {
                    curWeight += truck_weights[i];
                }
            }

            if(curWeight + truck_weights[curIdx] <= weight){
                q.offer(truck_weights[curIdx]);
                curIdx++;
            }
            if(curIdx == truck_weights.length){
                answer += bridge_length;
                break;
            }
            for(int i=0;i<curIdx;i++){
                if(truck_times[i] <= bridge_length) {
                    truck_times[i]++;
                    if (truck_times[i] > bridge_length) {
                        q.poll();
                    }
                }
            }

            answer++;
        }

        return answer +1;
    }
}
