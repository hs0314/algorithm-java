package programmers.sort;

import java.util.Arrays;

public class HIndex {
    public static void main (String[] args) {
        int[] array = {0,0,0,0};
        int maxVal = -1;

        Arrays.sort(array);

        for(int i=0;i<=array[array.length-1];i++){
            int h = i;
            int hidx=0;
            for(int j=0;j<array.length;j++){
                if(array[j] >= h){
                    hidx = j;
                    break;
                }
            }

            if(array.length - hidx >= h && hidx+1 <= h) {
                if (maxVal < h) maxVal = h;
            }
        }

        System.out.println(maxVal);
    }
}
