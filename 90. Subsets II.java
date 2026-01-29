// Given an integer array nums that 
// may contain duplicates, return all
// possible (the power set).

// The solution set must not contain
// duplicate subsets. Return the solution in any order.

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> sublist, int[] nums,int index){
        list.add(new ArrayList<>(sublist));

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            sublist.add(nums[i]);
            backtrack(list, sublist, nums,i+1);
            sublist.remove(sublist.size()-1);
        }
    }
}

//Time:O(n · 2ⁿ)
//Space:O(n · 2ⁿ)