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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int fDig1 = l1.val;
        int fDig2 = l2.val;
        int headDig = l1.val + l2.val;
        int carry = headDig/10;
        headDig %= 10;

        ListNode head = new ListNode(headDig);
        ListNode curr = head;

        l1 = l1.next;
        l2 = l2.next;

        while ((l1 != null || l2 != null) || (carry == 1)) {
            if (l1 == null && l2 == null) {
                ListNode ln = new ListNode(1);
                curr.next = ln;
                curr = ln;
                carry = 0;
                continue;
            }

            int dig = 0;
            if (l1 == null) {
                dig = l2.val + carry;
                carry = dig/10;
                dig %= 10;
                l2 = l2.next;
            }
            else if (l2 == null) {
                dig = l1.val + carry;
                carry = dig/10;
                dig %= 10;
                l1 = l1.next;
            }
            else {
                dig = l1.val + l2.val + carry;
                carry = dig/10;
                dig %= 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            
            ListNode ln = new ListNode(dig);
            curr.next = ln;
            curr = ln;
        }

        return head;

    }
}
