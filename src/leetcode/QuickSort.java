package leetcode;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(arr);
    }

     public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗을 기준으로 배열을 분할하고, 분할된 인덱스를 반환

            // 피벗은 여기서는 제일 high로 잡음
            int pivot = arr[high];
            int i = low;

            // 피벗을 기준으로 정렬
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    
                    // arr[i]와 arr[j] 교환
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                }
            }

            // 피벗을 제자리에 놓기
            int temp = arr[i];
            arr[i] = arr[high];
            arr[high] = temp;

            // 분할 인덱스 (현재 피벗에 들어간 idx)
            int partitionIndex = i;

            // 재귀적으로 왼쪽과 오른쪽을 정렬
            quickSort(arr, low, partitionIndex - 1);  // 왼쪽 부분 배열 정렬
            quickSort(arr, partitionIndex + 1, high); // 오른쪽 부분 배열 정렬
        }
    }
}
