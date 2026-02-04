// There is an integer array nums sorted
// in non-decreasing order (not necessarily
// with distinct values).

// Before being passed to your function, 
// nums is rotated at an unknown pivot 
// index k (0 <= k < nums.length) such 
// that the resulting array is [nums[k],
// nums[k+1], ..., nums[n-1], nums[0],
// nums[1], ..., nums[k-1]] (0-indexed).
// For example, [0,1,2,4,4,4,5,6,6,7] 
// might be rotated at pivot index 5 and 
// become [4,5,6,6,7,0,1,2,4,4].

// Given the array nums after the rotation 
// and an integer target, return true if
// target is in nums, or false if it is not in nums.

// You must decrease the overall operation
// steps as much as possible.

// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums is guaranteed to be rotated at some pivot.
// -10^4 <= target <= 10^4
class Solution {
    public boolean search(int[] nums, int target) {
        return binary(nums,target,0,nums.length-1);
    }

    private boolean binary(int[] nums, int target,int l,int r){
        if(l>r){
            return false;
        }

        int mid=l+(r-l)/2;
        if(nums[mid]==target){
            return true;
        }
        if(nums[l]==nums[mid] && nums[mid]==nums[r]){
            return binary( nums, target, l+1, r-1);
        }

        if(nums[l]<=nums[mid]){
           if(nums[l]<=target && target<=nums[mid]){
            return binary( nums, target, l, mid-1);
           }
           else{
            return binary( nums, target, mid+1, r);
           }
        }
        else{
           if(nums[mid]<=target && target<=nums[r]){
            return binary( nums, target, mid+1, r);
           }
           else{
            return binary( nums, target, l, mid-1);            
           }
        }
    }
}