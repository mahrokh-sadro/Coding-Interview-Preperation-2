// Given the root of a binary tree, check
// whether it is a mirror of itself (i.e.,
// symmetric around its center).

// The number of nodes in the tree is 
// in the range [1, 1000].
// -100 <= Node.val <= 100

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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }

        if(p==null || q==null || p.val!=q.val){
            return false;
        }

        return isMirror(p.right,q.left) && isMirror(p.left,q.right);
    }

}
// Time: O(n)
// Space: O(h) 
