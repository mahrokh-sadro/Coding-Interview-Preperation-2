// You are given an integer array cost
// where cost[i] is the cost of ith step
// on a staircase. Once you pay the cost,
// you can either climb one or two steps.

// You can either start from the step with
// index 0, or the step with index 1.

// Return the minimum cost to reach the
// top of the floor.
// 2 <= cost.length <= 1000
// 0 <= cost[i] <= 999
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

// If there are only two steps, return the cheaper one
// because we can start at either step 0 or 1
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }

// dp[i] = minimum cost to reach
//step i (1-indexed)
// i.e., cost to stand on step i
//along the optimal path
        int[] dp = new int[n + 1];

// Base cases:
// Step 1: cost to stand on first step
        dp[1] = cost[0];
// Step 2: cost to stand on second step
// Note: We do NOT take Math.min(cost[0]
//, cost[1])
// because dp[i] is defined as the cost
//to **stand on step i**
// The recurrence below will correctly
//compute the optimal path from here
        dp[2] = cost[1];

// Fill dp array from step 3 to step n
        for (int i = 3; i <= n; i++) {
// Minimum cost to reach current step =
//cost of this step + 
// min(cost to reach previous step, cost
//to reach step before previous)
            dp[i] = cost[i - 1] + Math.min(dp[i - 1], dp[i - 2]);
        } 

// Minimum cost to reach the top can come 
//from either last step or second-last step
        return Math.min(dp[n], dp[n - 1]); 
    }
}

// Time = O(n)
// Space = O(1)