// Given the head of a singly linked list,
// group all the nodes with odd indices
// together followed by the nodes with
// even indices, and return the reordered list.
// The first node is considered odd,
// and the second node is even, and so on.
// Note that the relative order inside
// both the even and odd groups should 
// remain as it was in the input.

// You must solve the problem in O(1) 
// extra space complexity and O(n) time complexity.

// The number of nodes in the linked list
// is in the range [0, 10^4].
// -10^6 <= Node.val <= 10^6
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode odd=new ListNode();
        ListNode even=new ListNode();
        ListNode oddHead=odd;
        ListNode evenHead=even;

        while(head!=null){
            odd.next=head;
            odd=odd.next;
            head=head.next;
            even.next=head;
            even=even.next;
            if(head!=null){
              head=head.next;
            }
        }

        odd.next=evenHead.next;
        return oddHead.next;
    }
}