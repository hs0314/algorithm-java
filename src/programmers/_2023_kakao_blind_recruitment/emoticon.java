package programmers._2023_kakao_blind_recruitment;

import java.util.ArrayList;
import java.util.List;

public class emoticon {
    public static void main(String[] args) {
        Solution_emoticon s = new Solution_emoticon();
        s.solution(new int[][]{
                {40,10000},
                {25,10000}},
                new int[]{7000,9000});
    }
}

class Solution_emoticon {

    int maxNewUserCnt = 0;
    int maxTotalSellprc = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        /*
         - 할인율 10,20,30,40 픽스고 이모티콘은 7개 이하니까 전수체크 가능
         - 가입자 증가가 판매금액보다 우선

         - 이모티콘에 각 할인율 조합별 결과 체크 필요
           => 이모티콘을 전체사용자 max 할인율 커버되는 할인율부터 시작해서 가입자가 내려가지 않는선에서 할인율 제일 낮추기..
         */
        List<Emoticon> emoticonList = new ArrayList<>();

        for (int i = 0; i < emoticons.length; i++) {
            Emoticon e = new Emoticon(emoticons[i], 10);
            emoticonList.add(e);
        }

        adjustDcRate(0, users, emoticonList);

        return new int[]{maxNewUserCnt, maxTotalSellprc};
    }

    public void adjustDcRate(int index, int[][] users, List<Emoticon> emoticonList) {
        if(index == emoticonList.size()) {
            // 최대 가입자수 체크
            int newUserCnt = 0;
            int totalSellprc = 0;
            for (int i = 0; i < users.length; i++) {
                int willingToBuy = 0;
                for (Emoticon emoticon : emoticonList) {
                    if (users[i][0] <= emoticon.getDcRate()) {
                        willingToBuy += emoticon.getDcPrice();
                    }
                }

                if (users[i][1] <= willingToBuy) {
                    newUserCnt++;
                    willingToBuy = 0;
                }
                totalSellprc += willingToBuy;
            }

            if (maxNewUserCnt < newUserCnt) {
                maxNewUserCnt = newUserCnt;
                maxTotalSellprc = totalSellprc;
            } else if (maxNewUserCnt == newUserCnt) {
                maxTotalSellprc = Math.max(maxTotalSellprc, totalSellprc);
            }

            return;
        }

        for(int i=10;i<=40;i+=10){
            emoticonList.get(index).setDcRate(i);
            adjustDcRate(index + 1, users, emoticonList);
        }
    }

    class Emoticon {
        private int price;
        private int dcRate;

        public Emoticon(int price, int dcRate) {
            this.price = price;
            this.dcRate = dcRate;
        }

        public int getDcPrice(){
            return this.price *(100-dcRate) / 100;
        }

        public int getDcRate() {
            return dcRate;
        }

        public void setDcRate(int dcRate) {
            this.dcRate = dcRate;
        }
    }
}