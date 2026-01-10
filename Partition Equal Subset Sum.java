// Given an integer array nums, return true if you
// can partition the array into two subsets such
// that the sum of the elements in both subsets
// is equal or false otherwise.
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num; 
        }

        if (sum % 2 == 1) {
            return false; 
        }
        int target = sum / 2;
// why target+1? 
// dp[i] represents whether a subset sum of 'i' is possible.
// So we need indices from 0 to target → size = target + 1
        boolean[] dp = new boolean[target + 1];
// sum 0 is always possible (empty subset)
        dp[0] = true; 

// iterate through each number in nums
        for (int num : nums) {
// why go from target down to num?
// Going backwards ensures each number is only used once (0/1 knapsack)
            //Update all possible sums using this number
            for (int i = target; i >= num; i--) {
// why dp[i] = dp[i] || dp[i - num]?
// dp[i] becomes true if:
// 1. it was already possible before, OR
// 2. by including 'num', we can reach sum i (dp[i-num] was true)
                dp[i] = dp[i] || dp[i - num];
            }
        }

 // can we form a subset with sum = target?
        return dp[target];
    }
}
// Time: O(n * target)
// Space: O(target)
