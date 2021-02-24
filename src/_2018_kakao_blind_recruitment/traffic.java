package _2018_kakao_blind_recruitment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class traffic {
    public static void main(String[] args) {
        Solution_traffic s = new Solution_traffic();
        s.solution(new String[] {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"});
    }
}

class Solution_traffic{
    public int solution(String[] lines) {
        int answer = 0;
        List<Time> timeList = new ArrayList<>();

        /*
         s부분을 ms단위로 변환해서 계산 => 1초계산 시 범위는 0 ~ 0.999 로 보기

         start - end 에 대한 쌍으로 저장해서 start 기준 정렬해두고 최소초부터 1초씩 체크해서 max 구하기
         */

        for(String line : lines){
            // string 처리
            String ts = line.split(" ")[1]; // 응답완료시간
            String t = line.split(" ")[2].replace("s",""); // 처리시간

            // procSec -> milisec으로 변경
            int procSec = (int)(Double.parseDouble(t) * 1000);

            // 종료시간 milisec으로 변경
            int milisec = getMillis(
                    Integer.parseInt(ts.split(":")[0]),
                    Integer.parseInt(ts.split(":")[1]),
                    Double.parseDouble(ts.split(":")[2]));

            Time endTime = new Time(
                    milisec+999,
                    "2E");

            // 시작시간 계산해서 timeList에 추가
            Time startTime = new Time(
                    milisec - procSec + 1,
                    "1S");


            timeList.add(startTime);
            timeList.add(endTime);
        }

        // start 시간 기준 오름차순 정렬
        timeList.sort(Comparator.comparing(Time::getSecond).thenComparing(Time::getState));


        int cnt = 0;
        for(Time time : timeList){
            if("1S".equals(time.getState())) cnt++;
            else cnt--;

            if(answer < cnt) answer = cnt;
        }


        return answer;
    }

    int getMillis(int time, int minute, double second){
        return (time*3600 *1000) + (minute*60 * 1000) + (int)(second * 1000);
    }
}

class Time{
    private int second; // milisec
    private String state; // S, E 구분

    public Time(int _second, String _state){
        this.second = _second;
        this.state = _state;
    }

    public int getSecond() {
        return second;
    }

    public String getState(){
        return state;
    }
}
