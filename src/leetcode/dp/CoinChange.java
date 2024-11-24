package leetcode.dp;

import java.util.Arrays;

public class CoinChange {
    /*
     * coins금액이 주어졌을때 amount를 만들 수 있는 최소한의 코인수
     * 
     * constraints
     * - 0 <= amount <= 10000
     * - 코인금액은 int범위
     * - 1 <= coin갯수 <= 12
     * 
     * todo
     * - programmers.dp O(N)
     * - 금액 1부터 amount까지 올라가면서 각 금액별 최소코인사용수 도출
     * - 각 금액별 coins[] 돌면서 현 idx-coins[i]금액의 answer값 + 1
     * 
     * tc / vrfc
     * - amount에 비해 큰단위의 코인만 있는 경우
     * - 아예 답을 못찾는 경우
     */
    public static void main(String[] args) {
        int[] coins = new int[] {2 };
        int amount = 3;
        int[] answer = new int[4];

        // 초기화
        Arrays.fill(answer, -1);
        answer[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            // amount를 넘어가는 코인은 셋팅할 필요 없음
            if (coins[i] <= amount) {
                answer[coins[i]] = 1;
            }
        }

        // 각 금액별 coins[] 돌면서 현 idx-coins[i]금액 min값 +1 을 answer[현재 amount]와 비교
        for (int i = 0; i <= amount; i++) {
            int minUsedCoin = Integer.MAX_VALUE;

            for (int j=0;j<coins.length;j++){
                
                if (i - coins[j] >= 0 && answer[i - coins[j]] > 0 ) {
                    minUsedCoin = Math.min(minUsedCoin, answer[i - coins[j]]+1);
                }
            }

            if (minUsedCoin != Integer.MAX_VALUE && (answer[i] == -1 || minUsedCoin < answer[i])) {
                answer[i] = minUsedCoin;
            }
        }

        System.out.println(answer[amount]);

    }
}
