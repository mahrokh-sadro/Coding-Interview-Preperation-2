// Given the head of a linked list, reverse
// the nodes of the list k at a time, and
// return the modified list.
// k is a positive integer and is less
// than or equal to the length of the
// linked list. If the number of nodes
// is not a multiple of k then left-out
// nodes, in the end, should remain as
// it is.
// You may not alter the values in the 
// list's nodes, only nodes themselves
// may be changed.
// The number of nodes in the list is n.
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) return head;
            tail = tail.next;
        }

        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverse(ListNode cur, ListNode end) {
        ListNode prev = null;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
//time:O(n)
//space:O(n)

class Solution {
   // Reverse nodes in k-group iteratively
    public ListNode reverseKGroup(ListNode head, int k) {
        // Return early if list is empty or k is 1 (no reversal needed)
        if (head == null || k == 1)
            return head;
        // Create a dummy node to simplify head handling
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // groupPrev points to the node before the current group
        ListNode groupPrev = dummy;
        // cur points to the current node at the start of each group
        ListNode cur = head;
        // Iterate through the list as long as there are nodes left
        while (cur != null) {
            // Find the kth node from cur
            ListNode kth = cur;
            int count = 0;
            while (kth != null && count < k) {
                kth = kth.next;
                count++;
            }
            // If fewer than k nodes remain, stop the loop
            if (count < k)
                break;
            // nextGroup points to the node after the kth node
            ListNode nextGroup = kth;
            // Reverse the current k nodes
            ListNode newHead = reverse(cur, nextGroup);
            // Connect previous group with the newly reversed group
            groupPrev.next = newHead;
            // Move groupPrev to the tail of the reversed group
            groupPrev = cur;
            // Move cur to the start of the next group
            cur = nextGroup;
        }
        // Return the new head of the list
        return dummy.next;
    }
    // Reverse nodes from start up to (but not including) end
    private ListNode reverse(ListNode start, ListNode end) {
        // prev will eventually be the new head of the reversed segment
        ListNode prev = end;
        // curr traverses the segment
        ListNode curr = start;
        // Reverse the links until reaching end
        while (curr != end) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        // Return new head of reversed segment
        return prev;
    }


}