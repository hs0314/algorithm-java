package programmers._2022_kakao_blind_recruitment;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class parkingfee {
    public static void main(String[] args) {
        Solution_parkingfee s = new Solution_parkingfee();

        // 주어진 fees 배열과 records 배열
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };

        // solution 메소드 호출
        s.solution(fees, records);
    }
}

class Solution_parkingfee {
    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> carParkingTimeMap = new TreeMap<>();
        Map<String, String> carParkingStatMap = new HashMap<>();
        for(int i=0;i< records.length;i++){
            String[] record = records[i].split(" ");
            String time = record[0];
            String car = record[1];
            String inOrOut = record[2];

            if("IN".equals(inOrOut)) {
                carParkingStatMap.put(car, time);
            } else if("OUT".equals(inOrOut)) {
                String inTime = carParkingStatMap.get(car);
                carParkingTimeMap.put(car, carParkingTimeMap.getOrDefault(car,0) + this.calculateTime(inTime, time));
                carParkingStatMap.remove(car);
            }
        }

        // 출차 안한 차들 일괄처리
        for(String car : carParkingStatMap.keySet()) {
            int time = carParkingTimeMap.getOrDefault(car,0) + this.calculateTime(carParkingStatMap.get(car), "23:59");

            carParkingTimeMap.put(car, time);
        }

        int[] answer = new int[carParkingTimeMap.size()];
        int idx = 0;
        
        for(String car : carParkingTimeMap.keySet()) {
            answer[idx++] = this.calcuateFee(carParkingTimeMap.get(car), fees);
        }

        return answer;
    }

    private int calcuateFee(Integer time, int[] fees) {
        int fee = 0;
        /*
        fee -> 기본시간(분) / 기본요금 / 단위시간 / 단위요금
         */
        int baseMin = fees[0];
        int baseFee = fees[1];
        int unitMin = fees[2];
        int unitFee = fees[3];

        if (time >= baseMin) {
            fee += baseFee;
            time -= baseMin;

            fee += (int) Math.ceil((double)time / (double)unitMin) * unitFee;
        } else {
            fee = baseFee;
        }



        return fee;
    }

    private Integer calculateTime(String in, String out) {
        int time;
        int minute;

        String[] inStr = in.split(":");
        String[] outStr = out.split(":");

        time = Integer.parseInt(outStr[0]) - Integer.parseInt(inStr[0]);
        minute = Integer.parseInt(outStr[1]) - Integer.parseInt(inStr[1]);

        if(minute < 0) {
            time--;
            minute+=60;
        }

        return time*60 + minute;
    }
}