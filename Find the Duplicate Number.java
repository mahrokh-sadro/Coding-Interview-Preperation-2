// Given an array of integers nums 
// containing n + 1 integers where
// each integer is in the range [1, n] inclusive.

// There is only one repeated number
// in nums, return this repeated number.

// You must solve the problem without
// modifying the array nums and using
// only constant extra space.

// 1 <= n <= 105
// nums.length == n + 1
// 1 <= nums[i] <= n
// All the integers in nums appear
// only once except for precisely 
// one integer which appears two or more times.
class Solution {
    public int findDuplicate(int[] nums) {
        int fast=nums[0];
        int slow=nums[0];
        do{
           fast=nums[nums[fast]];
           slow=nums[slow];
        }while(fast!=slow);

        fast=nums[0];
        while(fast!=slow){
           fast=nums[fast];
           slow=nums[slow];
        }
        return fast;
    }
}
//time:o(n)
//space:o(1)