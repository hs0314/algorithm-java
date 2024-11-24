package leetcode.sort;

import java.util.Arrays;

public class MergeSort {
    /*
    머지소트
    - dived and conquer 기법으로 분할 -> 정복 -> 병합으로 구분
    - 시간복잡도 O(NlogN) / 공간복잡도 O(N) - 병합처리를 위한 추가 메모리 사용
    - 분할이 불가능할떄까지 나눈 후, 병합하면서 소팅
     */
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        mergeSort(arr, 0, arr.length-1);
    }

    public static void mergeSort(int[] arr, int left, int right) {

        // 더 이상 분할 불가할때까지
        if (left < right) {
            int mid = (right+left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);

            // 현재 나눠진 left / right array를 병합하면서 소팅
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        // length는 idx 고려해서 +1 씩
        int[] leftArr = new int[mid-left+1];
        int[] rightArr = new int[right-mid];
        int leftArrIdx = 0;
        int rightArrIdx = 0;

        System.arraycopy(arr, left, leftArr, 0, mid-left+1);
        System.arraycopy(arr, mid+1, rightArr, 0, right-mid);

        // left, right arr 비교
        int arrIdx = left; // right까지

        while (leftArrIdx < leftArr.length && rightArrIdx < rightArr.length) {

            if (leftArr[leftArrIdx] <= rightArr[rightArrIdx]) {
                arr[arrIdx++] = leftArr[leftArrIdx++];
            } else if (leftArr[leftArrIdx] > rightArr[rightArrIdx]) {
                arr[arrIdx++] = rightArr[rightArrIdx++];
            }
        }

        // 남은 left / right arr값 셋팅
        while (leftArrIdx < leftArr.length) {
            arr[arrIdx++] = leftArr[leftArrIdx++];
        }
        while (rightArrIdx < rightArr.length) {
            arr[arrIdx++] = rightArr[rightArrIdx++];
        }
    }
}
