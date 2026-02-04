// Given the head of a linked list, 
// reverse the nodes of the list k at 
// a time, and return the modified list.
// k is a positive integer and is less
// than or equal to the length of the 
// linked list. If the number of nodes
// is not a multiple of k then left-out
// nodes, in the end, should remain as it is.
// You may not alter the values in the 
// list's nodes, only nodes themselves may be changed.

// The number of nodes in the list is n.
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000
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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode tail=head;
        for(int i=0;i<k;i++){
            if(tail==null) return head;
            tail=tail.next;
        }

        ListNode newHead=reverse(head,tail);
        head.next=reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverse(ListNode head,ListNode tail){
       ListNode cur=head;
       ListNode pre=null;
       while(cur!=tail){
          ListNode next=cur.next;
          cur.next=pre;
          pre=cur;
          cur=next;
       }
       return pre;
    }
}
// Time : O(n)
// Space : O(n / k) (recursion stack)