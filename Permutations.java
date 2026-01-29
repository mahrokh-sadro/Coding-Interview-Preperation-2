// Given an array nums of distinct integers, 
// return all the possible . You can return
// the answer in any order.

// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,nums,new ArrayList<>());
        return list;
    }

    private void backtrack(List<List<Integer>> list,int[] nums,List<Integer> sublist){
        if(sublist.size()==nums.length){
            list.add(new ArrayList<>(sublist));
        }

        for(int i=0;i<nums.length;i++){
            if(sublist.contains(nums[i])){
                continue;
            }
            sublist.add(nums[i]);
            backtrack( list, nums, sublist);
            sublist.remove(sublist.size()-1);
        }
        
    }
}

// Time: O(n * n!) — there are n! permutations
// of n numbers, and copying each permutation
// takes O(n) time.

// Space: O(n * n!) — storing all permutations
// in the result list dominates space; 
// recursion stack and current path take O(n).