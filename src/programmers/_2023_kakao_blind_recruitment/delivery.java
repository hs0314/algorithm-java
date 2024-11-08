package programmers._2023_kakao_blind_recruitment;

public class delivery {
    public static void main(String[] args) {
        Solution_delivery s = new Solution_delivery();
        System.out.println(s.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}) == 16);
        System.out.println(s.solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}) == 30);
        System.out.println(s.solution(4, 5, new int[]{8, 0, 8, 0, 4}, new int[]{0, 0, 0, 0, 20}) == 50);
        System.out.println(s.solution(2, 2, new int[]{0, 1}, new int[]{0, 4}) == 8);
        System.out.println(s.solution(2, 2, new int[]{0, 0}, new int[]{0, 6}) == 12);
        System.out.println(s.solution(2, 2, new int[]{0, 0}, new int[]{4, 0}) == 4);
        System.out.println(s.solution(2, 2, new int[]{5, 0}, new int[]{0, 3}) == 10);
        System.out.println(s.solution(5, 3, new int[]{5, 0, 5}, new int[]{0, 1, 10}) == 16);
        System.out.println(s.solution(5, 3, new int[]{5, 1, 5}, new int[]{0, 1, 10}) == 16);
        System.out.println(s.solution(2, 3, new int[]{0, 6, 13}, new int[]{19, 0, 1}) == 54);
        System.out.println(s.solution(2, 3, new int[]{4, 2, 1}, new int[]{0, 4, 1}) == 16);
        System.out.println(s.solution(4, 5, new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}) == 12);
    }
}

class Solution_delivery {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        /*
        n이 100000이므로 완전탐색불가
        - n까지의 최소값을 구하면 n+1까지의 최소값 구하기에 도움이되나? programmers.dp?
        - n집까지의 배달/수거를 합산으로 봐도 될듯?
        - 배달수거 총합으로 몇번 움직일지는 구할수있음 -> 출발지를 선정하기가..?
          => 목적지(처음엔 제일먼곳) 설정해서 최대 배달, 수거 가능한 갯수고 이후 목적지 선정
         */
        long answer = 0;

        for (int i = n-1; i >= 0; i--) {

            if(deliveries[i] == 0 && pickups[i] == 0){
                continue;
            }

            int deliverySum = 0;
            int pickupSum = 0;

            // cap을 넘기면 delivery, pickup둘다 처리가능할때까지 앞집 케파 땡겨오기
            int dindex=i;
            int pindex=i;
            while(cap > deliverySum || cap > pickupSum) {
                if(dindex < 0 && pindex < 0){
                    break;
                }

                if(cap <= deliverySum + deliveries[dindex] || cap < pickupSum + pickups[pindex]) {
                    if (dindex >= 0 && deliverySum < cap && cap <= deliverySum + deliveries[dindex]) {
                        deliveries[dindex] -= cap - deliverySum;
                        deliverySum = cap;
                        i = dindex+1;
                    }else{
                        dindex--;
                    }

                    if (pindex >=0 && pickupSum < cap && cap < pickupSum + pickups[pindex]) {
                        pickups[pindex] -= cap - pickupSum;
                        pickupSum = cap;
                        i = pindex+1;
                    }else{
                        pindex--;
                    }
                }else {
                    deliverySum += deliveries[dindex];
                    pickupSum += pickups[pindex];
                    deliveries[dindex] = 0;
                    pickups[pindex] = 0;
                    dindex--;
                    pindex--;

                    i = Math.max(dindex, pindex)+1;
                }
            }
            answer += ((long)(i+1) * 2);
        }

        return answer;
    }
}