// Given the root of a binary tree, return
// the zigzag level order traversal of its
// nodes' values. (i.e., from left to right,
// then right to left for the next level and
// alternate between).

// The number of nodes in the tree is in the
// range [0, 2000].
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

        boolean isLeftToRight=true;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> level=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();

                if(isLeftToRight){
                  level.addLast(node.val);
                }
                else{
                   level.addFirst(node.val); 
                }

                if(node.left!=null){
                   que.add(node.left); 
                }
                if(node.right!=null){
                   que.add(node.right); 
                }
            }
            isLeftToRight=!isLeftToRight;
            list.add(level);
        }
        return list;
    }
}
//time: O(n)
//space:O(n)
