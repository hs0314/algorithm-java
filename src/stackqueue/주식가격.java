package stackqueue;

public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};

        Solution_주식가격 s = new Solution_주식가격();

        System.out.println(s.solution(prices));
    }
}

class Solution_주식가격{
    int[] answer;
    public int[] solution(int[] prices) {
        answer = new int[prices.length];

        for(int i=0;i<prices.length-1;i++){
            useStack(i, i+1, prices.length-1, prices);
        }
        return answer;
    }

    void useStack(int idx, int nextIdx, int endIdx, int[] prices){

        if(nextIdx == endIdx || prices[idx] > prices[nextIdx]){
            answer[idx] = nextIdx - idx;
            return;
        }

        useStack(idx, nextIdx+1, endIdx, prices);
    }
}
