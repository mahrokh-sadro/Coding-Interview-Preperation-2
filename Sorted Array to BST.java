// Given an integer array nums where the
// elements are sorted in ascending order,
// convert it to a height-balanced binary
// search tree.
// Constraints:
// 1 ≤ nums.length ≤ 10^4
// −10^4 ≤ nums[i] ≤ 10^4
// nums is sorted in strictly increasing order
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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return binary( nums,0,nums.length-1);
    }

    private TreeNode binary(int[] nums,int l,int r){
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=binary( nums, l,mid-1);
        root.right=binary( nums, mid+1, r);
        return root;
    }
}
//Time:O(n)
//Space:O(log n)