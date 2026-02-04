// Given the root of a binary tree, 
// return the inorder traversal of its nodes' values.

// The number of nodes in the tree is 
// in the range [0, 100].
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(root,list);
        return list;
    }

    private void dfs(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }

        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}
// Time : O(n)
// Space : (aux / recursion): O(h)
// Space : (including output): O(n)
