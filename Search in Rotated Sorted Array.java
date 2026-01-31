// There is an integer array nums sorted
// in ascending order (with distinct values).

// Prior to being passed to your function,
// nums is possibly left rotated at an 
// unknown index k (1 <= k < nums.length)
// such that the resulting array is 
// [nums[k], nums[k+1], ..., nums[n-1],
// nums[0], nums[1], ..., nums[k-1]] 
// (0-indexed). For example, [0,1,2,4,5,6,7] 
// might be left rotated by 3 indices and
// become [4,5,6,7,0,1,2].

// Given the array nums after the possible
// rotation and an integer target, return
// the index of target if it is in nums,
// or -1 if it is not in nums.

// You must write an algorithm with 
// O(log n) runtime complexity.
// 1 ≤ nums.length ≤ 5000
// -10^4 ≤ nums[i] ≤ 10^4
// All values of nums are unique.
// nums is an ascending array that is 
// possibly rotated.
// -10^4 ≤ target ≤ 10^4
class Solution {
    public int search(int[] nums, int target) {
        return binary(nums,target,0,nums.length-1);
    }

    private int binary(int[] nums, int target,int l,int r){
        if(l>r){
            return -1;
        }

        int mid=l+(r-l)/2;
        if(nums[mid]==target){
            return mid;
        }

        if(nums[l]<=nums[mid]){
          if(nums[l]<=target &&  target<=nums[mid]){
            return binary(nums, target, l, mid-1);
          }
          else{
            return binary(nums, target, mid+1, r);
          }
        }
        else{
          if(nums[mid]<=target &&  target<=nums[r]){
            return binary(nums, target, mid+1, r);
          }
          else{
            return binary(nums, target, l, mid-1);
          }
        }
    }
}

//Time:O(log n)
//Space:O(log n) (due to recursion stack)