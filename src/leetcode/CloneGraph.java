package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {
    public static void main(String[] args) {
        /*
         * 동일한 그래프이되, 주소값은 다른 새로운 그래프를 return해야함
         * node index와 value는 같음
         * given node는 index 1 노드
         * 
         * constraints
         * - node val은 unique하고 1<= node.val <= 100
         * - self loop나 끊겨있는 노드 없음
         * 
         * todo
         * - 각 node를 1번부터 돌면서 neighbors를 보고 필요한 노드 생성
         * - neighbors 관계를 생성
         * - 새로 생성된 1번 노드 return
         */

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        // clone graph
        // stack에 넣어두고 하나씩 neighbors 생성 => 스택일 필요가 있나? 큐여도 상관없을듯
        Queue<Node> processQueue = new LinkedList<>();
        Map<Integer, Node> nodeMap = new HashMap<>(); // chk를 위해서 새로 생성하는노드가 아닌 input 노드로 관리
        Set<Node> chkSet = new HashSet<>();
        Node head = null;

        processQueue.add(node1);

        // 새로운 노드 생성 시점은 언제?
        while (!processQueue.isEmpty() && node1 != null) {
            Node n = processQueue.poll();
            
            // 여기서 특정 n에 대한 처리를 해야 해당 n의 이웃은 다 생성하고 chkMap에 넣을 수 있음
            if (!nodeMap.containsKey(n.val)) {
                Node newNode = new Node(n.val);
                nodeMap.put(n.val, newNode);
                
                if (n.val == 1) {
                    head = newNode;
                }
            }

            chkSet.add(nodeMap.get(n.val));


            // todo: 여기서 위 chkset조건때문에 이웃으로 추가된 노드들의 이웃list셋팅이 불가함... -> 상호 list에 둘다넣기
            // 이미 chkSet에 해당 노드가 만들어져 있어도 아직 추가되지 않은 이웃이 있을수있음
            for(Node neighbor : n.neighbors) {
                
                // chkSet으로 처리가 전체 완료된 node는 스킵
                if (!chkSet.contains(nodeMap.get(neighbor.val))) {
                    processQueue.add(neighbor);
                
                
                    Node neighborNode = nodeMap.get(neighbor.val) != null ? nodeMap.get(neighbor.val) : new Node(neighbor.val);
                    
                    nodeMap.get(n.val).neighbors.add(neighborNode);
                    neighborNode.neighbors.add(nodeMap.get(n.val));
                    nodeMap.put(neighbor.val, neighborNode);
                }
            }
        }

        System.out.println(head);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
