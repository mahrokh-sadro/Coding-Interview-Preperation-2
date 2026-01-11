// Given a string s, find the length of the
// longest substring without duplicate characters.
// 0 <= s.length <= 5 * 10^4
// s consists of English letters, digits,
// symbols, and spaces.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n<2){
            return n;
        }

        int[] lastSeen=new int[128];
        Arrays.fill(lastSeen,-1);
        int l=0;
        int max=0;
        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            if(lastSeen[ch]>=l){
                l=lastSeen[ch]+1;
            }
            lastSeen[ch]=r;
            max=Math.max(max,r-l+1);
        }
        return max;

    }
}
// Time: O(n)
// Space: O(1)