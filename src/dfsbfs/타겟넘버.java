package dfsbfs;

public class 타겟넘버 {

    public static void main (String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 5;

        Solution_타겟넘버 s = new Solution_타겟넘버();
        s.solution(numbers, target);
    }
}

class Solution_타겟넘버{
    int answer=0;

    public int solution(int[] numbers, int target){
        dfs(numbers, target, 0, 0 );
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int sum){
        if(idx == numbers.length){
            if(sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, idx+1, sum+numbers[idx]);
        dfs(numbers, target, idx+1, sum-numbers[idx]);
    }
}
