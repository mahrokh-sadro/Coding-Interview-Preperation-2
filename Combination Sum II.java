// Given a collection of candidate numbers 
// (candidates) and a target number (target),
// find all unique combinations in candidates
// where the candidate numbers sum to target.
// Each number in candidates may only be
// used once in the combination.

// Note: The solution set must not contain 
// duplicate combinations.

// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,new ArrayList<Integer>(),candidates, target,0,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> curlist,int[] nums, int target,int curSum,int index){
         if(curSum==target){
            list.add(new ArrayList<>(curlist));
         }

         for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            if(curSum+nums[i]<=target){
                curlist.add(nums[i]);
                backtrack(list,curlist,nums, target, curSum+nums[i], i+1);
                curlist.remove(curlist.size()-1);
            }
         }
    }
}

// Time : O(n · 2^n)
// Space : (aux only): O(n)
// Space : (including output): O(n · 2^n)