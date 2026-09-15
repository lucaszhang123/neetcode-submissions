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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h = new ListNode(0);
        ListNode curr = h;

        while (list1 != null || list2 != null) {

            if (list1 == null) {
                ListNode ln = new ListNode(list2.val);
                curr.next = ln;
                curr = ln;
                list2 = list2.next;
                continue;
            }

            if (list2 == null) {
                ListNode ln = new ListNode(list1.val);
                curr.next = ln;
                curr = ln;
                list1 = list1.next;
                continue;
            }
            

            int smaller;
            if (list1.val < list2.val) {
                smaller = list1.val;
                list1 = list1.next;
            }
            else {
                smaller = list2.val;
                list2 = list2.next;
            }

            ListNode ln = new ListNode(smaller);
            curr.next = ln;
            curr = ln;

        }

        return h.next;
    }
}