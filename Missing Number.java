// Given an array nums containing n distinct
// numbers in the range [0, n], return 
// the only number in the range that is 
// missing from the array.

// n == nums.length
// 1 <= n <= 10^4
// 0 <= nums[i] <= n
// All the numbers of nums are unique.
class Solution {
    public int missingNumber(int[] nums) {
        int curSum=0;
        for(int num:nums){
            curSum+=num;
        }
        int n=nums.length; 
        int expectedSum=n*(n+1)/2;
        return Math.abs(curSum-expectedSum);
        
    }
}