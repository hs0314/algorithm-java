package leetcode.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr)); // 정렬 결과 출력
    }

    public static void quickSort(int[] arr, int left, int right) {

        // divide가 단일 원소인 경우까지 처리
        if (left < right) {

            int pidx = partition(arr, left, right);

            // 해결이 된 pidx는 두고 좌우 분할정복으로 처리
            quickSort(arr, left, pidx - 1);
            quickSort(arr, pidx + 1, right);
        }
    }

    // 퀵소트 피벗 기준으로 작은 수, 큰 수 좌우로 나누기
    public static int partition(int[] arr, int left, int right) {
        // 피벗은 여기서는 제일 큰 인덱스로 잡음
        int pivot = arr[right];
        int pidx = left;

        // 피벗을 기준으로 작은 수, 큰 수 정렬
        for (int i = left; i < right; i++) {

            if (arr[i] <= pivot) {
                // 현재 pivot보다 작은 값을 left~right의 앞부터 채워감
                // 이후 idx가 피벗의 정위치
                swap(arr, pidx, i);
                pidx++;
            }
        }

        // 피벗을 정위치로 이동
        swap(arr, pidx, right);

        return pidx;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
