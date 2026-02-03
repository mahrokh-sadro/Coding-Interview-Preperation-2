// Serialization is the process of converting
// a data structure or object into a sequence
// of bits so that it can be stored in a file
// or memory buffer, or transmitted across a 
// network connection link to be reconstructed
// later in the same or another computer environment.

// Design an algorithm to serialize and 
// deserialize a binary tree. There is no 
// restriction on how your serialization/deserialization algorithm should work. You just need 
// to ensure that a binary tree can be serialized
// to a string and this string can be 
// deserialized to the original tree structure.

// Clarification: The input/output format is
// the same as how LeetCode serializes a
// binary tree. You do not necessarily need
// to follow this format, so please be 
// creative and come up with different
// approaches yourself.

// The number of nodes in the tree 
// is in the range [0, 10^4].
// -1000 <= Node.val <= 1000
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        StringBuilder sb=new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node==null){
                sb.append("N"+" ");
            }
            else{
                queue.add(node.left);
                queue.add(node.right);
                sb.append(node.val+" ");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        
        String[] splits=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(splits[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            for(int i=1;i<splits.length-1;i++){
                TreeNode node=queue.poll();
                if(!splits[i].equals("N")){
                    TreeNode left=new TreeNode(Integer.parseInt(splits[i]));
                    node.left=left;
                    queue.add(left);
                }
                if(!splits[++i].equals("N")){
                    TreeNode right=new TreeNode(Integer.parseInt(splits[i]));
                    node.right=right;
                    queue.add(right);
                }
            }
        }
        return root;
    }
}
//Time:O(n)
//Space:O(n)

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
