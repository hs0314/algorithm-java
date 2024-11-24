package leetcode.divideconquer;

import com.sun.source.tree.Tree;

public class ConvertSortedArrayToBinarySearchTree {
    /*
    정렬된 int array가 있을때 이를 height-balanced bst로 변환
    -> 서브트리의 height가 동일하도록 설정

    제한
    - array 건수 1~10000
    - nus값은 int 범위

    todo
    - 오름차순 정렬 배열 -> 반씩 나눠서 head를 정하고 좌우 sub tree 완성
     */
    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
        sortedArrayToBST(new int[]{1,3});
        sortedArrayToBST(new int[]{1});
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        TreeNode head = divideConquer(nums, 0, nums.length-1);

        return head;
    }

    public static TreeNode divideConquer(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int rootIdx = start + ((end-start+1) / 2);

        TreeNode node = new TreeNode(nums[rootIdx]);
        node.left = divideConquer(nums, start, rootIdx-1);
        node.right = divideConquer(nums, rootIdx+1, end);

        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
