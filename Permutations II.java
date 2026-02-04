// Given a collection of numbers,
// nums, that might contain duplicates,
// return all possible unique permutations in any order.

// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        backtrack(list, new ArrayList<>(),nums,visited);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> sublist,int[] nums,boolean[] visited){
        if(sublist.size()==nums.length){
            list.add(new ArrayList<>(sublist));
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]){
                continue;
            }
        
            sublist.add(nums[i]);
            visited[i]=true;
            backtrack(list,sublist,nums,visited);
            sublist.remove(sublist.size()-1);
            visited[i]=false;
        }
    }
}

// Time: O(n · n!)
// Space: O(n) (or O(n · n!) including output)