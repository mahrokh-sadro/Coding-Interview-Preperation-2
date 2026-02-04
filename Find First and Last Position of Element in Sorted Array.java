// Given an array of integers nums 
// sorted in non-decreasing order, find
// the starting and ending position of
// a given target value.
// If target is not found in the array,
// return [-1, -1].

// You must write an algorithm with 
// O(log n) runtime complexity.

// 0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
// nums is a non-decreasing array.
// -10^9 <= target <= 10^9
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=binary(nums,target,true);
        int right=binary(nums,target,false);
        return new int[]{left,right};
    }

    private int binary(int[] nums, int target,boolean isLeftBound){
        int l=0;
        int r=nums.length-1;
        int index=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                index=mid;
                if(isLeftBound){
                   r=mid-1;
                }
                else{
                   l=mid+1;
                }
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return index;
    }
}
//time:O(log n)
//space:O(1)
