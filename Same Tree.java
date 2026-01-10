// Given the roots of two binary trees p and q,
// write a function to check if they are the
// same or not.

// Two binary trees are considered the same if
// they are structurally identical, and the
// nodes have the same value.
// 0 ≤ number of nodes ≤ 100
// -10^4 ≤ Node.val ≤ 10^4

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }

        if(p==null || q==null || p.val!=q.val){
            return false;
        }

        return isSameTree( p.left,  q.left) && isSameTree( p.right,  q.right);
    }
}
// Time:  O(n)
// Space: O(h)   // recursion stack (worst case O(n))
