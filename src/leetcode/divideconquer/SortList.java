package leetcode.divideconquer;

public class SortList {
    /*
    linkedList의 head값을 주면 해당 값을 오름차순 정렬해서 반환

    제한
    - 노드 수 0 ~ 50000 (O(n2)은 불가)
    - value는 int 범위

    todo
    - ? linkedList에서 중간 node를 어떻게 식별하는가?
    - 중간노드 식별 시-> 분할
     */
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
