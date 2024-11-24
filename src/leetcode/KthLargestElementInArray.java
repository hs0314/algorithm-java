package leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    /*
    array내에서 k번째로 큰 수 반환

    제한
    - array길이 1~100000 (k도 1이상)
    - num은 int 범위

    todo
    - max heap 자료구조 사용 (priorityQueue) => 삽입이 O(logN)이어서 제한에 걸리지 않음

     */
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public static int findKthLargest(int[] nums, int k) {

        // 기본은 min heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        for (int num : nums) {
            maxHeap.offer(num);
        }

        for (int i=0;i<k-1;i++) {
            maxHeap.poll();
        }

        return maxHeap.poll();
    }
}
