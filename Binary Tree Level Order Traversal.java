// Given the root of a binary tree, 
// return the level order traversal 
// of its nodes' values. (i.e., from
// left to right, level by level).

// The number of nodes in the tree
// is in the range [0, 2000].
// -1000 <= Node.val <= 1000
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> sublist=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                   queue.add(node.left);
                }
                if(node.right!=null){
                   queue.add(node.right);
                }
                sublist.add(node.val);
            }
            list.add(sublist);
        }
        return list;
    }
}
//time:O(n)
//space:O(n)
