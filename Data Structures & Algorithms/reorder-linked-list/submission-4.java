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
    public void reorderList(ListNode head) {
        if (head == null) return;

        List<ListNode> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head);
            head = head.next;
        }

        ListNode sol = arr.get(0);
        ListNode curr = sol;
        for (int i = 1; i <= arr.size()/2; i++) {
            if (arr.size() != 2 * i) {
                curr.next = arr.get(arr.size() - i);
                curr = curr.next;

                curr.next = arr.get(i);
                curr = curr.next;
            }
            else {
                curr.next = arr.get(i);
                curr = curr.next;
                
            }
        
        }
        curr.next = null;
    }

    /*
    0 1 2 3 4 5 6
    1 - 3

    0 6 1 5 2 4

    0 1 2 3 4 5 6 7 

    7 1 

    */
}
