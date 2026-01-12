// Given the root of a binary tree and
// an integer targetSum, return true if
// the tree has a root-to-leaf path such
// that adding up all the values along
// the path equals targetSum.

// A leaf is a node with no children.
// The number of nodes in the tree is
// in the range [0, 5000].
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000

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
    boolean isPossible=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,0);
        return isPossible;
    }
// Local curSum: Correct, because each
// path has its own sum.
// Global curSum: Incorrect, because
// all paths share the same variable
// and sums get mixed.
// Always pass path-specific data as
// parameters in recursive tree problems.
    private void dfs(TreeNode root, int targetSum,int curSum){
        if(root==null){
            return;
        }

        curSum+=root.val;
        if(root.left==null && root.right==null && curSum==targetSum){
            isPossible=true;
            return;
        }

        dfs( root.left,  targetSum, curSum);
        dfs( root.right,  targetSum, curSum);

    }
}
//Time:o(n)
//Space:o(h)
