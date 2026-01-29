// Given an integer array nums, 
// return true if you can partition
// the array into two subsets such 
// that the sum of the elements in
// both subsets is equal or false otherwise.

// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
class Solution {
    public boolean canPartition(int[] nums) {
        // Calculate total sum of array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // If sum is odd, it can't be split
        // into two equal subsets
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        // dp[i] = true if we can form sum i using
        // some subset of numbers
        // Size is target + 1 to cover sums from 
        //0 to target (inclusive)
        boolean[] dp = new boolean[target + 1];
        // Base case: sum 0 is always possible
        // (empty subset)
        dp[0] = true;
        // Process each number once (prevents 
        //reusing the same number)
        for (int num : nums) {
            // Iterate backwards to ensure each 
            //number is used at most once
            for (int i = target; i >= 0; i--) {
                // Check if current number can
                // contribute to sum i
                //num is the current number
                //i - num is the remaining sum after
                // using the current number num
                if (i - num >= 0) {
                    // dp[i] is true if:
                    // 1) it was already possible
                    // 2) or we can form (i - num)
                    // and add current num
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }

        // If we can form target sum, array can be partitioned equally
        return dp[target];
    }
}
//time:O(N∗M)
//space:O(M)

