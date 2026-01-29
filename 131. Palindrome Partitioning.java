// Given a string s, partition s such 
// that every of the partition is a .
// Return all possible palindrome partitioning of s.

// 1 <= s.length <= 16
// s contains only lowercase English letters.
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>  list=new ArrayList<>();
        backtrack(list,new ArrayList<>(),s,0);
        return list;
    }

    private void backtrack(List<List<String>>  list,
        List<String>  sublist, String s, int index){
        if(s.length()==index){
            list.add(new ArrayList<>(sublist));
        }

        for(int r=index;r<s.length();r++){
            if(isPalindrom(s,index,r)){
                sublist.add(s.substring(index,r+1));
                backtrack(list,sublist, s, r+1);
                sublist.remove(sublist.size()-1);
            }
        }
    }

    private boolean isPalindrom(String s,int l,int r){
         while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
               return false;
            }
            l++;
            r--;
         }
         return true;
    }
}

//Time:O(n × 2ⁿ)
//Space:O(n × 2ⁿ) (total), O(n) recursion stack