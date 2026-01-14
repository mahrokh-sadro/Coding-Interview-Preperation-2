// You are climbing a staircase. It 
// takes n steps to reach the top.

// Each time you can either climb 1
// or 2 steps. In how many distinct
// ways can you climb to the top?
// 1 <= n <= 45
class Solution {
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }

        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
// Time: O(n)
// Space: O(1)
