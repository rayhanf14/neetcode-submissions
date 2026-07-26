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
        ListNode f = head;
        ListNode s = head;
        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
        }
        ListNode l2 = s.next;
        s.next = null;
        //reverse 2nd half
        ListNode p = null;
        ListNode c = l2;
        while(c != null){
            ListNode n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        ListNode t1 = head;
        ListNode t2 = p;
        while(t1 != null && t2 != null){
            ListNode n1 = t1.next;
            ListNode n2 = t2.next;
            t1.next = t2;
            t2.next = n1;
            t1 = n1;
            t2 = n2;
        }
        return;
    }
}
