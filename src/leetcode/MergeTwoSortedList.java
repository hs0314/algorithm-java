package leetcode;
public class MergeTwoSortedList {
    /*
     * 두 정렬된 linkedList head list1, list2를 하나의 정렬된 list로 merge
     * 
     * todo
     * - 정렬된 리스트들이니까 하나씩 순회하면서 O(N)으로 list 결합을 하면 될듯 -> merge는 O(상수)로 처리가 가능할듯
     * - 현재 두 node 1,2비교해서 같거나 1보다 2가 클때까지.. 
     */
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(4);
        list1.next = list2;
        list2.next = list3;

        ListNode list4 = new ListNode(1);
        ListNode list5 = new ListNode(3);
        ListNode list6 = new ListNode(4);
        list4.next = list5;
        list5.next = list6;

        //list1, list4

        ListNode answerHead = null;
        ListNode cur = null;
        while (list1 != null && list4 != null) {
            
            if (list1.val < list4.val) {
                if (answerHead == null) {
                    answerHead = list1;
                    cur = answerHead;
                } else {
                    cur.next = list1;
                    cur = cur.next;
                }
                list1 = list1.next;
            } else {
                if (answerHead == null) {
                    answerHead = list4;
                    cur = answerHead;
                } else {
                    cur.next = list4;
                    cur = cur.next;
                }
                list4 = list4.next;
            }

        }

        // todo 남아있는 node 전체 추가
        if (list1 != null) {
            while(list1 != null) {
                if (answerHead == null) {
                    answerHead = list1;
                    cur = answerHead;
                } else {
                    cur.next = list1;
                    cur = cur.next;
                }
                list1 = list1.next;
            }
        }

        if (list4 != null) {
            while(list4 != null) {
                if (answerHead == null) {
                    answerHead = list4;
                    cur = answerHead;
                } else {
                    cur.next = list4;
                    cur = cur.next;
                }
                list4 = list4.next;
            }
        }

        System.out.println(answerHead);
        
    }


    public static class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
