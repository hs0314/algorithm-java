package leetcode.tree;

public class TreeTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);

        // 트리 생성
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // 전위 순회
        System.out.println("Preorder traversal:");
        preorderTraversal(root);  // 출력: 1 2 4 5 3
        
        System.out.println("\nInorder traversal:");
        inorderTraversal(root);   // 출력: 4 2 5 1 3
        
        System.out.println("\nPostorder traversal:");
        postorderTraversal(root); // 출력: 4 5 2 3 1
    }

    // 전위, 중위, 후위 순회 메서드 (위에서 정의한 것들 사용)
    public static void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public static void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public static void postorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    static class Node {
        int data;
        Node left, right;
    
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
