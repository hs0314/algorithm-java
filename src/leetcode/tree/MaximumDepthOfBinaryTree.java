package leetcode.tree;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    /*
     * 이진트리를 받아서 max depth 전달
     * 
     * constraints
     * - 0 <= node수 <= 10000
     * 
     * todo
     * - left, right 중에서 가장 deep하게 내려간 것의 max에 + 1
     * - 방법은 재귀를 써도 되고 BFS를 써도 됌
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode();
        TreeNode n2 = new TreeNode();
        TreeNode n3 = new TreeNode();

        n1.right = n2;
        n2.left = n3;

       // maxDepth1(n1);
        maxDepth2(n1);

    }

    //BFS
    // levelSize를 둬서 현재 node의 depth 판단
    public static int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // N번째(depth)의 노드의 자식 노드 추가
            for (int i=0;i<levelSize;i++) {
                TreeNode cur = queue.poll();

                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }

            depth++;
        }

        return depth;

    }

    // 재귀
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);

        return Math.max(left, right) + 1;

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
