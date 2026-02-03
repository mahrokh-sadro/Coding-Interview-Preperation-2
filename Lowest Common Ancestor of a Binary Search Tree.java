// Given a binary search tree (BST), 
// find the lowest common ancestor (LCA)
// node of two given nodes in the BST.

// According to the definition of LCA on
// Wikipedia: “The lowest common ancestor 
// is defined between two nodes p and q as
// the lowest node in T that has both p
// and q as descendants (where we allow 
// a node to be a descendant of itself).”

// The number of nodes in the tree is in the
// range [2, 10^5].
// -10^9 <= Node.val <= 10^9
// All Node.val are unique.
// p != q
// p and q will exist in the BST.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var cur=root;
        while(cur!=null){
            if(p.val>cur.val && q.val>cur.val){
               cur=cur.right;
            }
            else if(p.val<cur.val && q.val<cur.val){
               cur=cur.left;
            }
            else{
                return cur;
            }
        }
        return cur;
    }
}
//Time:O(h)
//Space:O(1)