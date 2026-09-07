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
        //merging for all rows 
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

        for(int i=0;i<lists.length;i++){
            if(lists[i] != null ){
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            temp.next = min;
            temp = temp.next;
            if(min.next != null){
                pq.offer(min.next);
            }
        }
        return dummy.next;
    }
}