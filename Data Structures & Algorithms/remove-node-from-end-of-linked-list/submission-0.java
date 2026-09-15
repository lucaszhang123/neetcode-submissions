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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int index = length - n;
        
        if (index == 0) return head.next;
        
        int count = 0;
        ListNode prev = head;
        ListNode curr = prev.next;

        while (count < index - 1) {
            curr = curr.next;
            prev = prev.next;

            count++;
        }

        prev.next = curr.next;

        return head;



    }
    /*
    index = 2
    
    1->2->3->4;
    p->c
    1->2
    2->3

    p.next = c.next


    */
}
