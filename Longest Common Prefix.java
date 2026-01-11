// Write a function to find the longest common
// prefix string amongst an array of strings.

// If there is no common prefix, return an
// empty string "".
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English
// letters if it is non-empty.

//Compare col-wise across words
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Step 1: Check for empty input
        if (strs == null || strs.length == 0) return "";
        // If no strings are provided, return
        // empty string as there is no common prefix
        // Step 2: Vertical scan characters
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i); 
        // Pick the i-th character from 
        //the first string as reference
        // Step 3: Compare this character
        // with the i-th character of all other strings
            for (int j = 1; j < strs.length; j++) {
        // Step 4: Check boundary and mismatch
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
        // If i is beyond current 
        //string length OR character doesn't match
        // Step 5: Return the prefix up to i (not including mismatch)
                    return strs[0].substring(0, i);
                }
            }
        // If all strings have the same 
        //character at position i, continue to next character
        }
        // Step 6: All characters of the first
        // string matched, so return it entirely
        return strs[0];
    }
}
// -Outer loop (i) → iterates over character 
// positions in the first string (strs[0])
// Think column by column.
// Each iteration checks the next character of
// the prefix.
// -Inner loop (j) → iterates over all the 
// other strings
// Think row by row.
// At the current character position i, it checks
// if all strings have the same character.

//same complexity for both, time is more efficint
//for col-wise

//time:o(m*n)
//n = number of strings
//m = max length of the first string

//space:o(1)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            while(!strs[i].startsWith(prefix)){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.length()==0) return "";
            }
        }

        return prefix;
    }
}


