// Given a linked list, swap every two
// adjacent nodes and return its head.
// You must solve the problem without 
// modifying the values in the list's 
// nodes (i.e., only nodes themselves may be changed.)

// The number of nodes in the list
// is in the range [0, 100].
// 0 <= Node.val <= 100
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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode tail=head;
        for(int i=0;i<2;i++){
            if(tail==null) return head;
            tail=tail.next;
        }

        ListNode newHead=reverse(head,tail);
        head.next=swapPairs(tail);
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

// Time:O(n)
// Space:O(n) recursion