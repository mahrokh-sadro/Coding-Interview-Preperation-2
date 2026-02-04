// Given an integer array nums, return
// true if any value appears at least 
// twice in the array, and return false
// if every element is distinct.

// 1 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}