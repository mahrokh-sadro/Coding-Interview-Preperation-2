// You are a professional robber planning to
// rob houses along a street. Each house has
// a certain amount of money stashed, the only
// constraint stopping you from robbing each 
// of them is that adjacent houses have security
// systems connected and it will automatically
// contact the police if two adjacent houses 
// were broken into on the same night.

// Given an integer array nums representing 
// the amount of money of each house, return 
// the maximum amount of money you can rob 
// tonight without alerting the police.

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            Math.max(nums[0],nums[1]);
        }

        int[] dp=new int[n+1];
        dp[1]=nums[0];
        dp[2]=Math.max(nums[0],nums[1]);
        for(int i=3;i<n+1;i++){
            dp[i]=Math.max(dp[i-2]+nums[i-1],dp[i-1]);
        }

        return dp[n];
    }
}
// Time: O(n)
// Space: O(1)