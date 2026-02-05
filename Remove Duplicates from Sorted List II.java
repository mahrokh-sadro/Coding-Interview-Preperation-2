// Given the head of a sorted linked list,
// delete all nodes that have duplicate
// numbers, leaving only distinct numbers
// from the original list. Return the
// linked list sorted as well.

// The number of nodes in the list is in 
// the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted 
// in ascending order.
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
// Edge case: empty list or single node → no duplicates possible
        if (head == null || head.next == null) {
            return head;
        }
// Dummy node placed before head
// This helps when the first few nodes themselves are duplicates
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
// prev always points to the last node in the result list
// (node BEFORE the current group we are examining)
        ListNode prev = dummy;
    // cur is used to traverse the list
        ListNode cur = head;
        while (cur != null) {
// Case 1: current value is duplicated
            if (cur.next != null && cur.val == cur.next.val) {
// Skip all nodes that have the same value as cur
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
// Move cur one step further to the first non-duplicate node
                cur = cur.next;
// Remove the entire duplicate group
// prev.next jumps over all duplicates
                prev.next = cur;
            }
            else {
// Case 2: current value is unique
// Move both pointers forward
                prev = prev.next;
                cur = cur.next;
            }
        }
// dummy.next is the head of the final cleaned list
        return dummy.next;
    }
}
