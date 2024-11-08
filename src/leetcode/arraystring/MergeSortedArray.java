package leetcode.arraystring;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution_MergeSortedArray s = new Solution_MergeSortedArray();
        s.merge(new int[]{1,2,4,5,6,0}, 5, new int[]{3}, 1);
        //s.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        //s.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{4,5,6}, 3);
        //s.merge(new int[]{1}, 1, new int[]{}, 0);
        //s.merge(new int[]{}, 0, new int[]{1}, 1);
    }
}

class Solution_MergeSortedArray{
    /*
    각 num1, num2가 요소가 num1 몇번째 idx로 들어가야하는지 정보를 정리하고 마지막 최종적으로
    m번만큼 루프 돌면서 처리

     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Idx = new int[m];
        int[] nums2Idx = new int[n];
        int order = 0;

        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < m || idx2 < n) {
            if (idx1 > m-1){
                nums2Idx[idx2++] = order++;
            } else if (idx2 > n-1){
                nums1Idx[idx1++] = order++;
            } else if (nums1[idx1] <= nums2[idx2]) {
                nums1Idx[idx1++] = order++;
            } else if (nums2[idx2] <= nums1[idx1]) {
                nums2Idx[idx2++] = order++;
            }
        }

        int[] nums1tmp = new int[m];
        for(int i=0;i<m;i++){
            nums1tmp[i] = nums1[i];
        }

        for (int i=0;i<m;i++) {
            nums1[nums1Idx[i]] = nums1tmp[i];
        }
        for (int j=0;j<n;j++){
            nums1[nums2Idx[j]] = nums2[j];
        }
    }
}
