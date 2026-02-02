// Given the head of a linked list,
// return the node where the cycle 
// begins. If there is no cycle, return null.

// There is a cycle in a linked list
// if there is some node in the list
// that can be reached again by continuously
// following the next pointer. Internally,
// pos is used to denote the index of 
// the node that tail's next pointer 
// is connected to (0-indexed). It is 
// -1 if there is no cycle. Note that 
// pos is not passed as a parameter.

// Do not modify the linked list.

// 0 <= number of nodes <= 10^4
// -10^5 <= Node.val <= 10^5
// -1, or a valid index of a node in 
// the linked list
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null ){
            return head;
        }

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode cur=head;
                while(cur!=slow){
                    cur=cur.next;
                    slow=slow.next;
                }
                return cur;
            }
        }
        return null;
    }
}