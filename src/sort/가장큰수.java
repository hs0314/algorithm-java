package sort;

import java.util.Arrays;

public class 가장큰수 {
    public static void main (String[] args) {
        int[] array = {3,30,34,5,9};
        String[] str_array = new String[array.length];

        String answer = "";

        for(int i=0;i<array.length;i++){
            str_array[i] = array[i] + "";
        }
        Arrays.sort(str_array, (e1, e2) -> Integer.parseInt(e2+e1) - Integer.parseInt(e1+e2));

        for(int i=0;i<str_array.length;i++){
            answer += str_array[i];
        }


        System.out.println(answer);
    }
}


