package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Quick {

    // 1. 피벗 선택
    //https://stackoverflow.com/questions/164163/quicksort-choosing-the-pivot
    // 전략은 랜덤이나, median of three를 사용(랜덤한 요소3개 뽑은 후, median 값으로 셋팅)
    public int getPivot(int[] arr){
        Random rand = new Random();
        ArrayList<Integer> randIdx = new ArrayList<>();

        for(int i=0;i<3;i++){
            randIdx.add(rand.nextInt(arr.length));
            Collections.sort(randIdx, (e1, e2) -> Integer.valueOf(arr[e1]).compareTo(Integer.valueOf(arr[e2])) );
        }
        return randIdx.get(1);
    }

    // 2. 분할
    public void quick(int[] arr, int pivot){
        //pivot 기준으로 좌우 분할


        int[] right = new int[arr.length];
        int rightIdx = 0;

        int[] left = new int[arr.length];
        int leftIdx = 0;

        for(int i=0;i<arr.length;i++) {
            if (i == pivot) continue;

            if (arr[i] <= arr[pivot]) {
                left[leftIdx++] = arr[i];
            } else {
                right[rightIdx++] = arr[i];
            }
        }

        quick(left, getPivot(left));
        quick(right, getPivot(right));
    }
}

/*
void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
 */


