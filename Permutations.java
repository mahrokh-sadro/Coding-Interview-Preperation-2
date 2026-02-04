// Given an array nums of distinct integers, 
// return all the possible . You can
// return the answer in any order.

// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,new ArrayList<Integer> (),nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> curlist,int[] nums){
        if(curlist.size()==nums.length){
            list.add(new ArrayList<>(curlist));
        }

        for(int i=0;i<nums.length;i++){
            if(curlist.contains(nums[i])){
                continue;
            }
            curlist.add(nums[i]);
            backtrack( list, curlist, nums);
            curlist.remove(curlist.size()-1);
        }
    }
}

// Time	O(n · n!)
// Space (with output)	O(n · n!)