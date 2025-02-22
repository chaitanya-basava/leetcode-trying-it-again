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
        int parity = 0;
        ListNode root = l1;
        ListNode lastL1 = null;
        int s;

        while(l1 != null && l2 != null) {
            s = l1.val + l2.val + parity;
            l1.val = s % 10;
            parity = s / 10;
            lastL1 = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            s = l1.val + parity;
            l1.val = s % 10;
            parity = s / 10;
            lastL1 = l1;
            l1 = l1.next;
        }
        while(l2 != null) {
            lastL1.next = l2;
            lastL1 = l2;

            s = l2.val + parity;
            l2.val = s % 10;
            parity = s / 10;

            l2 = l2.next;
        }

        if(parity != 0) {
            lastL1.next = new ListNode(parity);
        }

        return root;
    }
}