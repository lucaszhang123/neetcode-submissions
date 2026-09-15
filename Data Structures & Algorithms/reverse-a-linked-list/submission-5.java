/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode rHead = head;
        ListNode rChain = new ListNode(head.val);

        while (rHead.next != null) {
            ListNode next = new ListNode(rHead.next.val);
            next.next = rChain;
            rChain = next;

            rHead = rHead.next;
        }

        return rChain;

    }

    
}
