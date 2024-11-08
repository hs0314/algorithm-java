package leetcode.arraystring;

public class BestTimeToBuyAndSellStock1 {
    /*
     * prices 배열은 i인덱스별 i번째날의 주식값
     * 사는날 / 파는날을 선택해서 가장 큰 수익 실현
     * 수익실현 불가 시 0 반환
     * 
     * 제한
     * - prices 건수 1~100000 (n제곱 불가)
     * - price가 0일 수 있음
     * 
     * todo
     * - 사는날이 파는날보다 idx 적음
     * - idx0~ prices length까지 각 index까지의 max를 구하기 (이때 거꾸로 loop)
     * - loop 돌면서 선택한 사는날(a) 값과 a~length까지 max 차를 구함 => O(N)
     * 
     * tc
     * - lenght =1
     * - 가격 다 동일한경우
     */
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,1,1,1,1,1}));
        System.out.println(maxProfit(new int[]{1}));
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int[] untilCurrentMax = new int[prices.length];
        int maxProfit = 0;

        // fixme : i~length까지의 max값을 어떻게 구할까
        untilCurrentMax[prices.length-1] = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            untilCurrentMax[i] = Math.max(prices[i], untilCurrentMax[i+1]);
        }

        for(int i=0;i<prices.length-1;i++) {
            
            // i를 사는날로 지정
            int buyPrice = prices[i];
            int sellPrice = untilCurrentMax[i+1];

            if (buyPrice < sellPrice && maxProfit < sellPrice - buyPrice) {
                maxProfit = sellPrice - buyPrice;
            }
        }

        return maxProfit;
    }
}
