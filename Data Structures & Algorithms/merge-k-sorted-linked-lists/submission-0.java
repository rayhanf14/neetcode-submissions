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
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        List<ListNode> l = new ArrayList<>(Arrays.asList(lists));
        while(l.size() > 1){
            ListNode l1 = l.get(0);
            ListNode l2 = l.get(1);
            ListNode m = helper(l1, l2);
            l.remove(0);
            l.remove(0);
            l.add(m);
        }
        return l.get(0);
    }
    public ListNode helper(ListNode l1, ListNode l2){
        ListNode dh = new ListNode(0);
        ListNode t = dh;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                t.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else{
                t.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            t = t.next;
        }
        if(l1 != null){
            t.next = l1;
        }
        else{
            t.next = l2;
        }
        return dh.next;
    }
}
