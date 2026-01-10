// You are given the heads of two sorted linked
// lists list1 and list2.

// Merge the two lists into one sorted list.
// The list should be made by splicing togethe
// r the nodes of the first two lists.

// Return the head of the merged linked list.
// The number of nodes in both lists is in
// the range [0, 50].
// -100 <= Node.val <= 100
// Both list1 and list2 are sorted in 
// non-decreasing order.
public ListNode mergeTwoLists(ListNode list1, ListNode list2){
    ListNode dummy=new ListNode(-1);
    ListNode head=dummy;
    while(list1!=null && list2!=null){
        if(list1.val<=list2.val){
            dummy.next=list1;
            list1=list1.next;
        }
        else{
            dummy.next=list2;
            list2=list2.next;
        }
        dummy=dummy.next;
    }

    if(list1!=null){
      dummy.next=list1;
    }
    if(list2!=null){
      dummy.next=list2;
    }
    return head.next;
}

// Time: O(n)
// Space: O(1)
