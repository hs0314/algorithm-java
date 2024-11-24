package leetcode.arraystring;

public class GasStation {
    /*
    gas -> 가스량 / 이전 idx에서 다음 i번째 gs까지 가는데 드는 가스량
    시계방향으로 전체 gs를 들를 수 있다면 그 시작 idx / 불가하면 -1 반환

    제한
    - gs수는 1~100000
    - gas, cost i번째값은 0~10000
    - 답은 unique

    todo
    - 모든 시뮬을 다 돌리기 (O(N))는 시간복잡도에 X
    - 시작가능 idx는 gas[i] >= cost[i+1]
    - cost합산 < gas합산 이면 무조건 싸이클링이 가능 (이걸 어떻게..)
    - A -> B 도달이 불가하면 그 사이 어느 시작점에서도 B는 도착 불가

    tc
    -
     */
    public static void main(String[] args) {
        canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});
        canCompleteCircuit(new int[]{1,1,1,1,1}, new int[]{1,1,1,1,1});
        canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3});
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        // O(N)
        // -> gas, cost 합산 계속 구하고 현재 남은가스가 <0 이라면 start를 다음idx로 넘기기
        // 어차피 답은 무조건 하나임이 보장되고, gasSum >= costSum이면 순회는 무조건 가능하므로.. 시작가능점을 찾으면 된다

        int gasSum = 0;
        int costSum = 0;
        int remains = 0;
        int startIdx = 0;

        for (int i=0;i<gas.length;i++) {
            gasSum += gas[i];
            costSum += cost[i];

            remains += gas[i] - cost[i];

            if (remains < 0) {
                remains = 0;
                startIdx = i+1; // 도달 불가한 i 다음 i로 시작점 변경
            }
        }

        if (gasSum < costSum) {
            return -1;
        } else {
            return startIdx;
        }
    }
}
