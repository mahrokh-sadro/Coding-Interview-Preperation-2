// Given the head of a singly linked list,
// return the middle node of the linked list.

// If there are two middle nodes, return
// the second middle node.
// The number of nodes in the list is in
// the range [1, 100].
// 1 <= Node.val <= 100

public ListNode middleNode(ListNode head) {
    if(head==null || head.next==null){
        return head;
    }

    ListNode fast=head;
    ListNode slow=head;
    while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
    }
    return slow;
}

// Time: O(n)
// Space: O(1)
