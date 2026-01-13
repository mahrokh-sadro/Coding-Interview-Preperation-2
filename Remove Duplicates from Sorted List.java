// Given the head of a sorted linked list,
// delete all duplicates such that each
// element appears only once. Return the 
// linked list sorted as well.
// The number of nodes in the list is in 
// the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in
// ascending order.

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode dummy=new ListNode();
        ListNode dummyHead=dummy;
        dummy.next=head;

        while(dummy.next!=null && dummy.next.next!=null){
            if(dummy.next.val==dummy.next.next.val){
               dummy.next.next=dummy.next.next.next;
            }
            else{
                dummy=dummy.next;
            }
        }
        return dummyHead.next;
    }
}
//Time: O(n)
//Space: O(1)
