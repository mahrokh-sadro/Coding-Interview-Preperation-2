// Given an array of integers nums and an
// integer target, return indices of the
// two numbers such that they add up to target.
// You may assume that each input would 
// have exactly one solution, and you may 
// not use the same element twice.
// You can return the answer in any order.

// 2 <= nums.length <= 10^4
// -10^9 <= nums[i] <= 10^9
// -10^9 <= target <= 10^9
// Only one valid answer exists.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int other=target-nums[i];
            if(map.containsKey(other)){
                return new int[]{map.get(other),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
