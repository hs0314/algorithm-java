package leetcode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AverageOfLevelsInBinaryTree {
    /*
     * bt root를 받아서 소수점5자리로 각 레벨의 평균값을 array에 담아서 return
     * 
     * 제한
     * - nodeVal은 인트범위
     * - tree의 노드 수는 10000까지면 레벨깊이는 그래봐야 ~15이내
     * 
     * todo
     * - 각 레벨에 대한 avg를 구해야하므로 bfs로 현 레벨까지의 avg구하기
     */
    public static void main(String[] args) {
        
    }

    public static List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> answer = new ArrayList<>();
        
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 한 사이클별 레벨
            int currentLevelSize = queue.size();
            
            double avg = 0;
            // 현재 레벨의 node의 자식노드들 추가
            for(int i=0;i<currentLevelSize;i++){
                
                TreeNode node = queue.poll();
                avg += node.val;

                // 자식 null여부 체크
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            answer.add( (double)Math.round(avg / (double)currentLevelSize * 100000.0)/100000.0);
        }

        return answer;
    }


    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
}