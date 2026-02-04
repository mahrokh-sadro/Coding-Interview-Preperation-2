// Given two integers n and k, return
// all possible combinations of k numbers 
// chosen from the range [1, n].
// You may return the answer in any order.

// 1 <= n <= 20
// 1 <= k <= n
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list, new ArrayList<>(), n, k, 1);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> curlist, int n, int size, int index){
        if(curlist.size()==size){
            list.add(new ArrayList<>(curlist));
            return;
        }

        for(int i=index;i<=n;i++){
            curlist.add(i);
            backtrack(list,curlist,n,size,i+1);
            curlist.remove(curlist.size()-1);
            
        }
    }
}

