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
