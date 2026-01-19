// You are given the root node of a
// binary tree, return the vertical 
// order traversal of its nodes' values.

// For the vertical order traversal,
// list the nodes column by column
// starting from the leftmost column
// and moving to the right.

// Within each column, the nodes should
// be listed in the order they appear
// from the top of the tree to the bottom.

// If two nodes are located at the same
// row and column, the node that appears
// to the left should come before the other.

// 0 <= number of nodes in the tree <= 100
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
public class Solution {
   public List<List<Integer>> verticalOrder(TreeNode root) {
        // If the tree is empty, return an empty result
        if (root == null) return new ArrayList<>();

        // TreeMap keeps columns sorted from leftmost to rightmost
        Map<Integer, List<Integer>> cols = new TreeMap<>();

        // Queue for BFS traversal: each entry stores a node and its column index
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        // Start with the root at column 0
        queue.add(new Pair<>(root, 0));

        // Perform level-order traversal (BFS)
        while (!queue.isEmpty()) {
        // Get the next node and its column position
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int pos = p.getValue();

            // If this column does not exist yet, create a new list
            if (!cols.containsKey(pos)) {
                cols.put(pos, new ArrayList<>());
            }

            // Add the current node's value to its corresponding column
            cols.get(pos).add(node.val);
            // Alternative:
            // cols.computeIfAbsent(pos, k -> new ArrayList<>()).add(node.val);

            // Add left child to the queue with column index - 1
            if (node.left != null) {
                queue.add(new Pair<>(node.left, pos - 1));
            }

            // Add right child to the queue with column index + 1
            if (node.right != null) {
                queue.add(new Pair<>(node.right, pos + 1));
            }
        }

        // Return the values grouped by columns in left-to-right order
        return new ArrayList<>(cols.values());
    }

}








