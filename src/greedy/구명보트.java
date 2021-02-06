package greedy;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {
        Solution_구명보트 s = new Solution_구명보트();
        s.solution(new int[]{70,50,80,50}, 100);
    }
}

class Solution_구명보트{
    public int solution(int[] people, int limit) {
        int start = 0;
        int end = people.length-1;
        int cur = end;
        int pair=0;

        Arrays.sort(people);
        while(start < end){
            if(people[start]+people[end] <= limit){
                pair++;
                end--;
                start++;
            }else{
                end--;
            }
        }

        return people.length - pair;
    }
}

