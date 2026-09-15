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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode n : lists) {
            pq.offer(n);
        }

        if (pq.size() == 0) return null;

        ListNode head = null;
        ListNode curr = null;

        while (pq.size() != 0) {
            ListNode currMin = pq.poll();
            if (head == null) {
                head = currMin;
                curr = currMin;
            }
            else {
                ListNode temp = new ListNode(currMin.val);
                curr.next = temp;
                curr = temp;
            }
            currMin = currMin.next;
            if (currMin != null) {
                pq.offer(currMin);
            }
        }

        return head;
    }
}
