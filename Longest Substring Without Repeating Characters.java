// Given a string s, find the length of
// the longest without duplicate characters.

// 0 <= s.length <= 5 * 10^4
// s consists of English letters,
// digits, symbols and spaces.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int maxLen=0;
        for(int r=0;r<s.length();r++){
            int index=s.indexOf(s.charAt(r),l);
            if(index!=r){
               l=index+1;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}
//Time:O(n²)
//Space:O(1)