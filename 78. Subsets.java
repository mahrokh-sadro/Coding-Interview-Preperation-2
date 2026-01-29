// Given an integer array nums of
// unique elements, return all
// possible (the power set).

// The solution set must not 
// contain duplicate subsets.
// Return the solution in any order.

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> sublist,int[] nums,int index){
        list.add(new ArrayList<>(sublist));

        for(int i=index;i<nums.length;i++){
            sublist.add(nums[i]);
            backtrack(list,sublist,nums, i+1);
            sublist.remove(sublist.size()-1);
        }
    }
}
//Time:O(n · 2ⁿ)
// There are 2ⁿ subsets.
// Each subset copy 
// (new ArrayList<>(sublist)) costs up to O(n).
// Total: 2ⁿ × n = O(n · 2ⁿ).
//Space:O(n · 2ⁿ)
// O(n · 2ⁿ) total (to store all subsets).
// O(n) auxiliary 
// (recursion stack + current subset).
