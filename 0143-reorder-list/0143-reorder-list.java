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
        //split at mid
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half
        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(secondHead != null){
            ListNode next = secondHead.next;
            secondHead.next = prev;
            prev = secondHead;
            secondHead = next;
        }
        secondHead = prev;
        ListNode firstHead = head;
        //add alternatively

        while(secondHead != null){
            ListNode next1 = firstHead.next;
            ListNode next2 = secondHead.next;
            firstHead.next = secondHead;
            secondHead.next = next1;
            firstHead = next1;
            secondHead = next2;
        }


    }
}