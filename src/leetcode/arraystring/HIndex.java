package leetcode.arraystring;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class HIndex {
    /*
     * int arr citations에서 i번째 숫자는 논문의 인용된 횟수
     * hindex에서 h는 최소 h이상의 h횟수 인용된 논문수가 있을경우의 max 값
     * 
     * 제한
     * - n은 citations 길이 1~5000
     * - 인용횟수는 0~1000
     * 
     * todo
     * - O(n2) -> loop 둘면서 0부터 체크해나가서 hindex 도출이 불가한 시점에 종료
     * - 더 나은 방법
     *  - 내림차순 정렬하면 idx를 1부터라고 할때 현 idx기준 citations[i]만큼 인용된 논문의 개수가 idx로 볼 수 있음
     * 
     * tc
     * - 인용횟수 0 1개
     */
    public static void main(String[] args) {
        //System.out.println(hIndex(new int[]{0}));
        System.out.println(hIndex(new int[]{3,0,6,1,5}));
        System.out.println(hIndex(new int[]{1,3,1}));
    }   

    public static int hIndex(int[] citations) {
        
        int answer=  0;
        
        Arrays.sort(citations);

        for(int i=citations.length-1;i>=0;i--) {
            // 논문 수
            int cnt = citations.length - i;
             
            if (citations[i] >= cnt) {
                answer = cnt;
            }
        }

        return answer;
    }
}
