// You are given the roots of two Binary 
// Search Trees (BSTs), root1 and root2.
// Both BSTs contain the same number of integers.

// Your task is to find all integers that
// are present in both BSTs and return them as a list.

public List<Integer> commonNumbers(TreeNode root1,TreeNode root2){
    Set<Integer> set1=new HashSet<>();
    dfs(root1,set1);
    
    Set<Integer> set2=new HashSet<>();
    dfs(root2,set2);
    
    List<Integer> list=new ArrayList<>();
    for(int num:set1){
        if(set2.contains(num)){
            list.add(num);
        }
    }
    return list;
}

private void dfs(TreeNode root,Set<Integer> set){
    if(root==null){
        return ;
    }
    
    dfs(root.left,set);
    set.add(root.val);
    dfs(root.right,set);
}


//Time: O(n)
//Space: O(n)
//(HashSets dominate; recursion stack is O(h) but smaller)













