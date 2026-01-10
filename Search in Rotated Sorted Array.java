// Given a sorted and rotated array arr[] of
// distinct elements, find
// the index of the given key in the array.
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// All values of nums are unique.
// nums is an ascending array that is possibly rotated.
// -10^4 <= target <= 10^4

class Solution {
    public int search(int[] nums, int target){
        return search(nums,target,0,nums.length-1);
    }

    private int search(int[] nums, int target,int l,int r){
        if(l>r){
            return -1;
        }
        
        int mid=l+(r-l)/2;
        if(nums[mid]==target){
            return mid;
        }
        
        if(nums[l]<=nums[mid]){
            if(nums[l]<=target && target<=nums[mid]){
                return search(nums,target,l,mid-1);
            }
            else{
                return search(nums,target,mid+1,r);
            }
        }
        else{
            if(nums[mid]<=target && target<=nums[r]){
                return search(nums,target,mid+1,r);
            }
            else{
                return search(nums,target,l,mid-1);
            }
        }
    }
}
// Time: O(log n)
// Space: O(log n)   // due to recursion

