// You are given an array of k linked-lists 
// lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted 
// linked-list and return it.

// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] is sorted in ascending order.
// The sum of all lists[i].length will not 
// exceed 10^4.
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
        int n=lists.length;
        if(n==0 ){
            return null;
        }

        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists){
            if(node!=null){
                pq.add(node);
            }
        }

        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;

        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            dummy.next=node;
            dummy=dummy.next;

            if(node.next!=null){
                pq.add(node.next);
            }
        }

        return head.next;

    }
}
//Time:O(n log k) 
//Space:O(n) total, O(k) for heap
//k = number of lists
