package _2023_naver_cic;

public class p2 {
    public static void main (String[] args) {
        int[] A = {1,2,3};
        boolean[] arr = new boolean[10];
        int min=1;

        for(int i=0;i<A.length;i++){
            arr[A[i]] = true;
        }

        for(int i=0;i<arr.length;i++){
            if(!arr[i]){
                min = i+1;
                break;
            }
        }
;
        System.out.println(min);
    }
}
