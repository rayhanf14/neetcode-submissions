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
        ListNode dummyHead = new ListNode(0);
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode temp = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ListNode n = new ListNode(list1.val);
                temp.next = n;  
                list1 = list1.next;
            }else{
                ListNode n = new ListNode(list2.val);
                temp.next = n;  
                list2 = list2.next;
            }
            temp = temp.next;
        }
        while(list1 != null){
            temp.next = list1;
            break;
        }
        while(list2 != null){
            temp.next = list2;
            break;
        }
        return dummyHead.next;

    }
}