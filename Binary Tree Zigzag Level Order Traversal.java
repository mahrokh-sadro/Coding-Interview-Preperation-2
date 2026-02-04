// Given the root of a binary tree, 
// return the zigzag level order traversal
// of its nodes' values. (i.e., from left 
// to right, then right to left for the 
// next level and alternate between).

// The number of nodes in the tree is in
// the range [0, 2000].
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean isLeftToRight=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> sublist=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(isLeftToRight){
                   sublist.addLast(node.val);
                }
                else{
                    sublist.addFirst(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            isLeftToRight=!isLeftToRight;
            list.add(sublist);
        }
        return list;
    }
}
// Time	O(n)
// Space	O(n)