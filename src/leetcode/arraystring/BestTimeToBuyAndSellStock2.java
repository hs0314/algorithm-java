package leetcode.arraystring;

public class BestTimeToBuyAndSellStock2 {
    /*
     * prices 배열에 i번째 일 주식가
     * 하루에 한번씩 사고 팔수있고 동일한 날에 사고파는게 가능
     * ** 주식은 한번에 하나만 보유 가능 (사고 -> 팔고 셋트)
     * 
     * 제약
     * - prices 건수 1~30000 (n2 불가)
     * - 금액 0~10000
     * 
     * todo
     * - 방법이 없으면 0 반환
     * - 다음날과 비교해서 오르는 날에 무조건 산다 -> n번 사고파는거보다 오랜기간 들고있는데 더 이익이 나는 경우?
     * ex) 1 2 3 4 100 => 결국 n일 나눠서 사고파는것과 동일
     */
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,1,1,1,1,1}));
        System.out.println(maxProfit(new int[]{1}));
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(maxProfit(new int[] { 7, 6, 3, 1 }));
        System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        boolean holding = false; // 들고있는 주식을 팔아야 다음번 살수있음
        for (int i = 0; i < prices.length; i++) {

            // 들고 있는 주식이 있으면 바로 판매
            if (holding) {
                maxProfit += (prices[i] - prices[i - 1]);
                holding = false;
            }

            // todo : 오늘보다 내일이 더 비싼지 체크해서 다시 보유
            if (i < prices.length - 1 && prices[i] < prices[i + 1]) {

                holding = true;
            }
        }

        return maxProfit;
    }
}
