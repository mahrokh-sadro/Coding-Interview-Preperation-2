// Given a string s consisting of words
// and spaces, return the length of the 
// last word in the string.

// A word is a maximal consisting of 
// non-space characters only.

// 1 <= s.length <= 104
// s consists of only English letters and spaces ' '.
// There will be at least one word in s.
class Solution {
    public int lengthOfLastWord(String s) {
        String str=s.trim();//O(n)
        String[] splits=str.split(" ");//O(n)
        return splits[splits.length-1].length();
    }
}