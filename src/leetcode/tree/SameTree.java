package leetcode.tree;

public class SameTree {
    /*
     * tree 동일여부 체크
     * - 구조, 노드 값 모두 같아야함
     * 
     * constraints
     * - node수 0~100 (0일때 체크)
     * - value -10000 ~ 10000
     * 
     * todo
     * - 순회하면서 하나씩 체크하면 되지 않을까? (구조가 달라도 순회값이 같을수있음 주의)
     *      - 재귀적으로 isSameTree를 현재 root 노드끼리 계속 비교..root가 다르거나 null이면 false
     * 
     * - 차라리 트리 하나에 대한 정보를 먼저 가지고 그 다음 트리와 비교하는게..?
     *      - 좌:L 우:R로 sb를 계속 추가하고 매칭되는 node를 Map에 넣어두면..?
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        n1.right = n2;
        n2.left = n3;
        TreeNode m1 = new TreeNode(2);
        TreeNode m2 = new TreeNode(2);
        TreeNode m3 = new TreeNode(2);
        m1.right = m2;
        m2.left = m3;

        System.out.println(isSameTree(n1, m1));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isTrue = true;
        
        if (p==null && q==null) {
            return true;
        }

        if( (p == null && q != null) || (p != null && q == null) || p.val != q.val) {
            return false;
        }

        //left, rigth 둘다 true인 경우이만 true
        isTrue = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return isTrue;
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
