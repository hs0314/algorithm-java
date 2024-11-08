package leetcode;
public class AddTwoNumbers {
    
    public static void main(String[] args) {
        /*
         * 하나 digit가 node하나이고 거꾸로 저장되어있음
         * 0자체나 앞자리 0이들어오는 등 잘못된 숫자는 없음
         * 
         * constraints
         * 1<= 노드수 <= 100 (100자리)
         * 
         * todo
         * - 두 숫자 자릿수가 다른 부분 조심
         * - 각 자리수별 올림 처리
         * - 순차적으로 계산하면서 바로 결과 listnode생성 -> head를 답으로 return
         * 
         * tc
         * - 자릿수 다른 계산
         * - 0 숫자
         * - 올림처리되는 것
         */

         ListNode n3 = new ListNode(9);
         ListNode n2 = new ListNode(9, n3);
         ListNode n1 = new ListNode(9, n2);

         ListNode m2 = new ListNode(9);
         ListNode m1 = new ListNode(5, m2);

         addTwoNumbers(n1, m1);
         
         
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
        ListNode first = new ListNode();
        ListNode before = null;
        
        // 두 수 합
        int extra = 0;
        while(l1 != null || l2 != null || extra > 0) {
            int val1 = (l1 == null ? 0 : l1.val);
            int val2 = (l2 == null ? 0 : l2.val);

            int result = (val1 + val2 + extra) % 10; //todo : int, double 연산 확인
            extra = (val1 + val2 + extra) / 10;

            ListNode newNode = new ListNode(result, null);

            if (before != null) {
                before.next = newNode;
            } else {
                first = newNode;
            }

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;

            before = newNode;
        }

        return first;
    }


    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
