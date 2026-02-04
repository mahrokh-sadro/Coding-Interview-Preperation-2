// Given n pairs of parentheses, write
// a function to generate all combinations 
// of well-formed parentheses.

// 1 <= n <= 8
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        backtrack(list,"", 0,0, n);
        return list;
    }

    private void backtrack(List<String> list,String s, int open,int close, int n
    ){
        if(open==n && close==n){
            list.add(s);
            return;
        }
         
        if(open<n){
           backtrack(list, s+"(", open+1, close, n);
        }
        if(close<open){
           backtrack(list, s+")", open, close+1, n);
        }
    }
}