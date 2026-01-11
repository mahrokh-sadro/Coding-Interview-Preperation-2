// Given two strings s and t, return true 
// if s is
// a subsequence of t, or false otherwise.
// A subsequence of a string is a new string
// that is formed from the original string
// by deleting some (can be none) of the 
// characters without disturbing the relative
// positions of the remaining characters.
// (i.e., "ace" is a subsequence of "abcde"
// while "aec" is not).
// Constraints:
// - 0 <= s.length <= 100
// - 0 <= t.length <= 10^4
// - s and t consist only of lowercase English
// letters.
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()){
            return false;
        }
  
        int i=0;
        int j=0;
        while(j<s.length() && i<t.length()){
            if(s.charAt(j)==t.charAt(i)){
              i++;
              j++;
            }
            else{
              i++;
            }
        } 

        return j==s.length();
    }
}

// Time:  O(t.length())
// Space: O(1)
import java.util.*;

class Solution {
    // Preprocessed positions of each character in t
    private List<Integer>[] charPositions = null;
    private String prevT = null; // store previously seen t

    public boolean isSubsequence(String s, String t) {
        // Preprocess t if it is new
        if (!t.equals(prevT)) {
            prevT = t;
            charPositions = new ArrayList[26]; // assuming lowercase letters
            for (int i = 0; i < 26; i++) charPositions[i] = new ArrayList<>();
            for (int i = 0; i < t.length(); i++) {
                charPositions[t.charAt(i) - 'a'].add(i);
            }
        }

        int prevIndex = -1; // previous matched index in t

        for (char c : s.toCharArray()) {
            List<Integer> positions = charPositions[c - 'a'];
            if (positions.isEmpty()) return false; // character not in t

            // Binary search for the first index > prevIndex
            int idx = Collections.binarySearch(positions, prevIndex + 1);
            if (idx < 0) idx = -idx - 1; // insertion point
            if (idx == positions.size()) return false; // no valid index found

            prevIndex = positions.get(idx);
        }

        return true;
    }
}

// Suppose there are lots of incoming s, 
// say s1, s2, ..., sk where k >= 10^9,
// and you want to check one by one to
// see if t has its subsequence. In this
// scenario, how would you change your code?