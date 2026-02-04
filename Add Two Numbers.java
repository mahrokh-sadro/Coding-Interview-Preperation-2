// You are given two non-empty linked 
// lists representing two non-negative
// integers. The digits are stored in 
// reverse order, and each of their nodes
// contains a single digit. Add the two
// numbers and return the sum as a linked list.

// You may assume the two numbers do not 
// contain any leading zero, except the 
// number 0 itself.

// The number of nodes in each linked
// list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a 
// number that does not have leading zeros.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;
        ListNode dummy=new ListNode();
        ListNode head=dummy;
        int carry=0;
        while(l1!=null || l2!=null ||carry!=0){
            sum=0;
            if(l1!=null){
               sum+=l1.val;
               l1=l1.next;
            }
            if(l2!=null){
               sum+=l2.val;
               l2=l2.next;
            }
            sum+=carry;
            carry=sum/10;
            int data=sum%10;
            ListNode cur=new ListNode(data);
            dummy.next=cur;
            dummy=dummy.next;
        }
        return head.next;
    }
}

// Time	O(n)
// Space	O(n) (for result list), O(1) auxiliary