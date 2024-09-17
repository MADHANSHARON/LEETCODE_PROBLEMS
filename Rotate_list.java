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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode itr = head;
        int n = 0;
        while(itr != null){
            n++;
            itr = itr.next;
        }
        k = k%n;
        if(k==0){
            return head;
        }
        itr = head;
        ListNode slow = head;
        while(k != 0){
            itr = itr.next;
            k--;
        }
        while(itr.next != null){
            itr = itr.next;
            slow = slow.next;
        }
        ListNode a = slow.next;
        slow.next = null;
        itr.next = head;
        return a;
    }
}
