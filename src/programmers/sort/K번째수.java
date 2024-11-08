package programmers.sort;

/*
 개선 포인트
 1. Arryas.copyOfRange(array, sIdx, eIdx) 사용
 2. 퀵소트 구현 및 사용
 */
public class K번째수 {
    public static void main (String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = new int[command.length];

        for(int i=0;i<command.length;i++){
            int sIdx = command[i][0] - 1;
            int eIdx = command[i][1] - 1;
            int[] tmpArr = new int[eIdx - sIdx + 1];

            for(int j=sIdx;j<=eIdx;j++){
                tmpArr[j-sIdx] = array[j];
            }

            for(int j=0;j<tmpArr.length;j++){
                for(int k=j+1;k<tmpArr.length;k++){
                    if(tmpArr[j] > tmpArr[k]){
                        int tmp = tmpArr[k];
                        tmpArr[k] = tmpArr[j];
                        tmpArr[j] = tmp ;
                    }
                }
            }
            answer[i] = tmpArr[command[i][2] - 1];
        }
        System.out.println(answer.toString());
    }
}