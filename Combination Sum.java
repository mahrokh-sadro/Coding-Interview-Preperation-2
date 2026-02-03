// Given an array of distinct integers 
// candidates and a target integer target,
// return a list of all unique combinations
// of candidates where the chosen numbers 
// sum to target. You may return the combinations
// in any order.

// The same number may be chosen from 
// candidates an unlimited number of times.
// Two combinations are unique if the of 
// at least one of the chosen numbers is different.

// The test cases are generated such that
// the number of unique combinations that
// sum up to target is less than 150
// combinations for the given input.

// 1 <= candidates.length <= 30
// 2 <= candidates[i] <= 40
// All elements of candidates are distinct.
// 1 <= target <= 40
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,new ArrayList<>(),candidates, target, 0,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> sublist, 
       int[] nums, int target,int curSum,int index){
          if(curSum==target){
            list.add(new ArrayList<>(sublist));
          }

          for(int i=index;i<nums.length;i++){
            if(curSum+nums[i]<=target){
                sublist.add(nums[i]);
                backtrack(list,sublist, nums,  target,curSum+nums[i],i);
                sublist.remove(sublist.size()-1);
            }
          }
    }
}
// Time: O(n^T × k)
//     n = choices per step
//     T = max recursion depth
//     k = cost to copy each combination into the result
// Space: O(T + n^T × k)
//     T = recursion stack depth
//     n^T × k = space for storing all valid combinations
