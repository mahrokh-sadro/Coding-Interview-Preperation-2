// A path in a binary tree is a sequence
// of nodes where each pair of adjacent
// nodes in the sequence has an edge 
// connecting them. A node can only
// appear in the sequence at most once.
// Note that the path does not need to
// pass through the root.

// The path sum of a path is the sum of
// the node's values in the path.

// Given the root of a binary tree, 
// return the maximum path sum of any
// non-empty path.

// - The number of nodes in the tree 
// is in the range [1, 3 * 10^4].
// - Node values are in the range [-1000, 1000].
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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getDepth(root);
        return maxSum;
    }

    private int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = Math.max(0, getDepth(root.left));
        int right = Math.max(0, getDepth(root.right));
        int curSum=left+right+root.val;
        maxSum=Math.max(maxSum,curSum);

        return Math.max(left,right)+root.val;
    }

}

// Time: O(n)
// Space: O(h)



