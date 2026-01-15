// Given a string s, return true if the
// s can be palindrome after deleting 
// at most one character from it.

// - 1 <= s.length <= 10^5
// - s consists of lowercase English letters.
class Solution {
    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;

        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
               return isPalindrom( s, l+1, r) ||
                      isPalindrom( s, l, r-1);
            }
            l++;
            r--;
        }
        return true;
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

// Time: O(n)
// Space: O(1)