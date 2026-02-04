// Given the root of a binary search 
// tree, and an integer k, return the
// kth smallest value (1-indexed) of
// all the values of the nodes in the tree.

// The number of nodes in the tree is n.
// 1 <= k <= n <= 10^4
// 0 <= Node.val <= 10^4
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
    int value=0;
    int index=0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return value;
    }

    private void dfs(TreeNode root, int k){
        if(root==null){
            return;
        }

        dfs(root.left,k);
        index++;
        if(index==k){
            value=root.val;
            return;
        }
        dfs(root.right,k);
    }
}

// Time:O(n) 
// Space:O(h) recursive stack