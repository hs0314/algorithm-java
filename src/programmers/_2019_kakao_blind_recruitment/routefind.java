package programmers._2019_kakao_blind_recruitment;
import java.util.*;

public class routefind {
    public static void main(String[] args) {
        Solutioin_routefind s = new Solutioin_routefind();
        s.solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
    }
}

class Solutioin_routefind{
    public int[][] solution(int[][] nodeinfo) {
        /*
         노드번호는 큰 의미가 없는듯?
         이진트리 규칙

         */
        int[][] answer = new int[2][nodeinfo.length];
        Map<Integer, List<Node>> nodeMap = new HashMap<>();
        List<Node> nodeList = new ArrayList<>();

        for(int i=0;i<nodeinfo.length;i++){
            Node n = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
            nodeList.add(n);
        }

        // array[x][1] 의 값 비교 정렬
        //Comparator.comparingInt(o -> o[1])

        //Arrays.programmers.sort(nodeinfo, (o1, o2) -> Integer.valueOf(o2[1]).compareTo(o1[1]) ;

        //todo 이거부터 조진게.. number 가 필요함
        /*
        Arrays.programmers.sort(nodeinfo, (o1, o2) -> {
            if(o1[1] < o2[1]) return 1;
            else if(o1[1] > o2[1]) return -1;
            else return Integer.valueOf(o1[0]).compareTo(o2[0]); // y가 같을경우 x오름차순 정렬
        });
         */

        nodeList.sort(Comparator.comparing(Node::getY).reversed().thenComparing(Node::getX));


        int cur_level = 0;
        int cur_depth = Integer.MAX_VALUE;
        for(Node cur : nodeList){
            if(cur.y < cur_depth) {
                // 다음 level
                cur_level++;
                cur_depth = cur.y;
            }

            // node map 에 node 추가
            List<Node> nlist = nodeMap.getOrDefault(cur_level, new ArrayList<Node>());
            nlist.add(cur);
            nodeMap.put(cur_level, nlist);

            // map에서 하나 상위노드들 다 꺼내온다음에 x좌표 비교로 left right 셋팅 처리
            // 이전 depth 노드가 있는 경우에만..
            if(nodeMap.get(cur_level-1) != null) {
                Node targetNode = new Node();
                List<Node> prevNodeList = nodeMap.get(cur_level - 1);
                for (Node prevLevelNode : prevNodeList) {
                    if (cur.x > prevLevelNode.x
                        && (prevNodeList.indexOf(prevLevelNode) == prevNodeList.size() -1
                        || cur.x < getFstDiffDirNodeX(prevLevelNode, "R"))){

                        // 케이스1. 이전 레벨 마지막 노드 x보다 오른쪽 위치
                        // 케이스2. 현재 노드의 두 단계 이전 x보다 크면 오른쪽 위치

                        // prevLevelNode 의 오른쪽 자식
                        targetNode = prevLevelNode;
                        targetNode.right = cur;

                        cur.parent = targetNode;
                        break;
                    } else if (cur.x < prevLevelNode.x
                    && (prevNodeList.indexOf(prevLevelNode) == 0
                    || cur.x > getFstDiffDirNodeX(prevLevelNode, "L"))) {
                        // prevLevelNode 의 왼쪽 자식
                        targetNode = prevLevelNode;
                        targetNode.left = cur;

                        cur.parent = targetNode;
                        break;
                    }
                }
            }
        }


        // 전위, 후위 표기 처리
        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();

        //root -> nodeList.get(0);
        preorder(nodeList.get(0), preList);
        postorder(nodeList.get(0), postList);

        for(int i=0;i<nodeinfo.length;i++) {
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }

        return answer;
    }
    public int getFstDiffDirNodeX(Node n, String curDir){
        if("R".equals(curDir)) {
            while(n.parent.right == n){
                n = n.parent;
            }
        }else{
            while(n.parent.left == n){
                n = n.parent;
            }
        }

        return n.parent.x;
    }
    public void preorder(Node n, List<Integer> preList){
        if(n != null){
            preList.add(n.num);
            preorder(n.left,preList);
            preorder(n.right,preList);
        }
    }
    public void postorder(Node n, List<Integer> postList){
        if(n != null){
            postorder(n.left,postList);
            postorder(n.right,postList);
            postList.add(n.num);
        }
    }

}

// 이진트리 표현법으로 array를 쓸지, 따로 Node 클래스로 처리할지 고민
class Node{
    int num;
    int x;
    int y;
    Node parent;
    Node left;
    Node right;
    public Node(){ }
    public Node(int _num, int _x, int _y){
        this.num = _num;
        this.x = _x;
        this.y = _y;
    }

    public int getNum() {
        return num;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}