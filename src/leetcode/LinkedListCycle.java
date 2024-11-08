package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        /**
         * Definition for singly-linked list.
         * class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) {
         *         val = x;
         *         next = null;
         *     }
         * }
         **/

        /*
         * linkedList에 사이클 여부 판단
         * pos는 tail노드의 next node => 요청파라미터로 안받음
         * 
         * constraints
         * - -100000 <= node value <= 100000
         * - 노드 수 0~10000  
         * 
         * todo
         *  - head 기준 전체 노드 방문이 가능하면 true가 맞지 않나?  (pos를 어떻게 써야될까)
         *  - 동일 value가 N번 나온다면..?
         * 
         * tc
         * - 노드가 0인 케이스
         * - 동일 value 반복이 되는 경우
         */

         ListNode n1 = new ListNode(3);
         ListNode n2 = new ListNode(2);
         ListNode n3 = new ListNode(0);
         ListNode n4 = new ListNode(4);

         n1.next = n2;
         n2.next = n3;
         n3.next = n4;
         n4.next = n2;

         System.out.println(hasCycle(n1));
            
    }

    /*
     * Fast and Slow Pointer 알고리즘의 원리:
        Slow Pointer는 링크드 리스트에서 한 번에 한 노드씩 이동합니다.
        Fast Pointer는 한 번에 두 노드씩 이동합니다.
        만약 링크드 리스트에 사이클이 없다면, Fast Pointer는 리스트의 끝에 도달합니다.
        만약 사이클이 있다면, Fast Pointer는 결국 Slow Pointer와 만납니다. 이것은 사이클이 존재함을 의미합니다.
     */

    public static boolean hasCycle(ListNode head) {
        // linkedList 순회하면서 전체 다 돌았는지 확인 O(N)
        //todo : 전체 노드수를 어떻게 확인하나 (set으로 봐도 되는가?)
        // -> cycle확인을 위해서 next를 보는 pointer, next.next를 보는 pointer(속도가 다른 두 포인터)를 두개 두고 둘이 같아지는 시점이 있으면 사이클이 있다고 판단..? ( fast and slow pointer algorithm)

        ListNode slow = head;
        ListNode fast = (head == null ? null : head.next);
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}
