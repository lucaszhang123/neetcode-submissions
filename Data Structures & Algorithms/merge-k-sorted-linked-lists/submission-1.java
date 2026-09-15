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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (ListNode n : lists) {
            while (n != null) {
                pq.offer(n.val);
                n = n.next;
            }
        }

        if (pq.size() == 0) return null;
        
        ListNode head = new ListNode(pq.poll());
        ListNode curr = head;

        while (pq.size() != 0) {
            ListNode currMin = new ListNode(pq.poll());
            curr.next = currMin;
            curr = currMin;
        }

        return head;
    }
}
