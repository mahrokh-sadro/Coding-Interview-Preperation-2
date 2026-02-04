// Find all valid combinations of k
// numbers that sum up to n such that 
// the following conditions are true:
// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid
// combinations. The list must not contain
// the same combination twice, and the
// combinations may be returned in any order.

// 2 <= k <= 9
// 1 <= n <= 60
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list, new ArrayList<>(), k, n, 1,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> sublist,int size, int target, int index,int curSum){
        if(sublist.size()==size && curSum==target){
            list.add(new ArrayList<>(sublist));
        }

        for(int i=index;i<=9;i++){
            if(curSum+i<=target){
                sublist.add(i);
                backtrack(list, sublist, size, target, i+1, curSum+i);
                sublist.remove(sublist.size()-1);
            }
        }
    }
}