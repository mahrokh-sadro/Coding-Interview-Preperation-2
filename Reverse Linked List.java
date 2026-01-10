// Given the head of a singly linked list,
// reverse the list, and return the reversed list.
// The number of nodes in the list is the
// range [0, 5000].
// -5000 <= Node.val <= 5000

 public ListNode reverseList(ListNode head) {
    if(head==null || head.next==null){
        return head;
    }

    ListNode cur=head;
    ListNode pre=null;
    while(cur!=null){
        ListNode next=cur.next;
        cur.next=pre;
        pre=cur;
        cur=next;
    }
    return pre;
}
// Time: O(n)
// Space: O(1)
