// Given the head of a linked list and a
// value x, partition it such that all
// nodes less than x come before nodes
// greater than or equal to x.

// You should preserve the original 
// relative order of the nodes in each
// of the two partitions.
// The number of nodes in the list is 
// in the range [0, 200].
// -100 <= Node.val <= 100
// -200 <= x <= 200
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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode lower=new ListNode();
        ListNode lowerHead=lower;

        ListNode higher=new ListNode();
        ListNode higherHead=higher;

        while(head!=null){
            if(head.val<x){
                lower.next=head;
                lower=lower.next;
            }
            else{
                higher.next=head;
                higher=higher.next;
            }
            head=head.next;
        }

        higher.next=null;
        lower.next=higherHead.next;
        return lowerHead.next;
    }
}

//Time:O(n)
//Space:O(1)







