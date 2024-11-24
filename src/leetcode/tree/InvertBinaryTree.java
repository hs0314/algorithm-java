package leetcode.tree;

public class InvertBinaryTree {
    /*
     * root를 받아서 해당 root좌우 반전시킨 tree의 root를 반환
     * 
     * constraints
     * - 노드 0~100 (0 체크)
     * 
     * todo
     * - 각 root노드 기준 좌우를 바꿔주면 전체 invert가 됌 (재귀적으로 좌우 스위칭)
     * - ** 재귀를 통해서 left
     */
    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        invertTree(n1);

        System.out.println("done");

    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        
        // 재귀 호출의 결과를 임시 변수에 저장
        // 주의) root.left에 바로 값을 넣어버리면 그다음 root.right처리할때는 이미 변경된 left값이 들어오게됌
        TreeNode leftSubtree = invertTree(root.right);
        TreeNode rightSubtree = invertTree(root.left);
        
        root.left = leftSubtree;
        root.right = rightSubtree;

        return root;
        
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
