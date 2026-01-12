// Given a string s and a dictionary 
// of strings wordDict, return true 
// if s can be segmented into a space-separated
// sequence of one or more dictionary words.

// Note that the same word in the dictionary
// may be reused multiple times in the
// segmentation.
// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase
// English letters.
// All the strings of wordDict are unique.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp=new Boolean[s.length()];
        return dfs( s, wordDict, dp, 0);
    }

    private boolean dfs(String s, List<String> wordDict, Boolean[] dp,int index){
        if(index==s.length()){
            return true;
        }

        if(dp[index]!=null){
            return dp[index];
        }

        for(String word:wordDict ){
            if(s.startsWith(word,index)){
                if(dfs(s, wordDict, dp,index+word.length())){
                    return true;
                }
            }
        }

        dp[index]=false;
        return false;


    }
}
//time:o(n^3)
//space:o(n)

