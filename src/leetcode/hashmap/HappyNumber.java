package leetcode.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.isHappy(19);
    }

    public static class Solution {
        /*
        특정값 n이 들어왔을대 happy num 여부 판단
        -> n에대해서 digit별 제곱 합산 => 최종적으로 1이면 happy num
        싸이클을 계속 돌면 false / happynum 가능이면 true

        제한
        - n은 1부터 int value (digit별 제곱 합산도 int 범위내)

        todo
        - map에 제곱합산에 대한 값을 넣어두고 loop돌면서 만약 동일 값이 이미 나왔다면 false
        */
        public boolean isHappy(int n) {
            Set<Integer> historySet = new HashSet<>();

            // 제곱합 처리
            while (n != 1) {
                String nStr = String.valueOf(n);
                int squareSum = 0;
                for(char c : nStr.toCharArray()) {
                    squareSum += Math.pow((c - '0'), 2);
                }

                if (historySet.contains(squareSum)) {
                    return false;
                } else {
                    historySet.add(squareSum);
                    n = squareSum;
                }
            }

            return true;
        }
    }
}
