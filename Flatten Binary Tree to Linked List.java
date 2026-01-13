// You are given an array of strings 
// tokens that represents an arithmetic
// expression in a Reverse Polish Notation.

// Evaluate the expression. Return an
// integer that represents the value
// of the expression.

// Note that:

// The valid operators are '+', '-', '*'
// , and '/'.
// Each operand may be an integer or 
// another expression.
// The division between two integers always
// truncates toward zero.
// There will not be any division by zero.
// The input represents a valid arithmetic
// expression in a reverse polish notation.
// The answer and all the intermediate 
// calculations can be represented in a
// 32-bit integer.

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int first=0;
        int second=0;
        //"4","13","5","/","+"
        for(String token:tokens){
            if(token.equals("+")){
              second=stack.pop();
              first=stack.pop();
              stack.push(first+second);
            }
            else if(token.equals("*")){
              second=stack.pop();
              first=stack.pop();
              stack.push(first*second);

            }
            else if(token.equals("-")){
               second=stack.pop();
               first=stack.pop(); 
               stack.push(first-second);

            }
            else if(token.equals("/")){
              second=stack.pop();
              first=stack.pop();
               stack.push(first/second);
            }
            else{
               stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}


// Time : O(n)
// Space : O(n)
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
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return null;

        TreeNode leftTail = dfs(root.left);
        TreeNode rightTail = dfs(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return root;
    }
}


// Time : O(n)
// Space : O(h)

