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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // nth from the last is (size - n) from start 
        //come size-n-1 point from the start and do skip ie a.next = a.next.next
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(n == size){
            return head.next;
        }
        temp = head;
        for(int i=1;i<(size-n);i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}