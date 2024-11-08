package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumAbsoluteDifferenceInBST {
    /*
     * root node를 받고 해당 BST에서 두 노드의 차가 가장 적은것
     * - bst 특성상.. 결국 각 노드에서 좌/우 자식노드와의 차이 절대값으로 구하면 될듯
     * 
     * 제한
     * - tree노드 수 2~10000
     * 
     * todo
     * - //BST 에서 inorder traversal은 정렬 결과
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);

        n2.left = n1;
        n2.right = n3;
        n4.left = n2;
        n4.right = n5;

        System.out.println(getMinimumDifference(n4));

    }

    public static int getMinimumDifference(TreeNode root) {
        // BST 에서 inorder traversal은 정렬 결과
        int min = Integer.MAX_VALUE;

        List<TreeNode> picked = new ArrayList<>();
        traversal(root, picked);

        for (int i = 1; i < picked.size(); i++) {
            min = Math.min(min, (picked.get(i).val - picked.get(i - 1).val));
        }

        return min;
    }

    public static void traversal(TreeNode cur, List<TreeNode> picked) {
        if (cur == null) {
            return;
        }

        traversal(cur.left, picked);
        picked.add(cur);
        traversal(cur.right, picked);
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
