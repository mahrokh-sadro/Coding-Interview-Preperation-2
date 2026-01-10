// Given the head of a linked list, rotate
// the list to the right by k places.
// Number of nodes: 0 <= n <= 500
// Node values: -100 <= Node.val <= 100
// Rotation steps: 0 <= k <= 2 * 10^9

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
        int size=size(head);

        if(head==null || k%size==0){
            return head;
        }

        k%=size;

        ListNode dummy=new ListNode(-1);
        ListNode dummyHead=dummy;
        dummy.next=head;

        ListNode fast=dummy;
        ListNode slow=dummy;
        for(int i=0;i<k;i++){
           fast=fast.next;
        }

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        ListNode newHead=slow.next;
        fast.next=head;
        slow.next=null;

        return newHead;
    }

    private int size(ListNode head){
        int count=0;
        ListNode cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
}
//time:o(n)
//space:o(1)

