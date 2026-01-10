// Given the root of a binary tree, 
// imagine yourself standing on the
// right side of it, return the values
// of the nodes you can see ordered from top to bottom.

//  The number of nodes in the tree is
//  in the range [0, 100].
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                if(node.left!=null){
                  que.add(node.left);
                }
                if(node.right!=null){
                  que.add(node.right);
                }
                if(i==size-1){
                   list.add(node.val);  
                }
            }
        }

        return list;
    }
}

// Time: O(n) 
// Space: O(n)