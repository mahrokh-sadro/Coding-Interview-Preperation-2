// Given the heads of two singly linked-lists
// headA and headB, return the node at which
// the two lists intersect. If the two linked
// lists have no intersection at all, return null.

// The number of nodes of listA is m.
// The number of nodes of listB is n.
// 1 <= m, n <= 3 * 10^4
// 1 <= Node.val <= 10^5
// 0 <= skipA <= m
// 0 <= skipB <= n
// intersectVal is 0 if listA and listB do 
// not intersect.
// intersectVal == listA[skipA] == listB[skipB]
// if listA and listB intersect.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size_a=size(headA);
        int size_b=size(headB);

        ListNode cur_a=headA;
        ListNode cur_b=headB;

        while(size_a<size_b)  {
            cur_b=cur_b.next;
            size_b--;
        }

        while(size_b<size_a){
            cur_a=cur_a.next;
            size_a--;
        }

        while(cur_a!=null && cur_b!=null){
            if(cur_a==cur_b){
                return cur_a;
            }
            cur_a=cur_a.next;
            cur_b=cur_b.next;
        }

        return null;
    }

    private int size(ListNode head){
        int count=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        return count;
    }
}

//time:o(m+n)
//space:o(1)




