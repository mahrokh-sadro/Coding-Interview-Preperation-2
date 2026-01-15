// Given two strings word1 and word2,
// return the minimum number of operations 
// required to convert word1 to word2.

// You have the following three
// operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character

// 0 <= word1.length, word2.length <= 500
// word1 and word2 consist of lowercase 
// English letters.
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

// dp[i][j] = minimum number of 
//operations to convert 
// first i characters of word1 to
//first j characters of word2
        int[][] dp = new int[m+1][n+1];

// Base case 1:
// Convert first i chars of word1 to
//empty string → delete all i chars
// Example: word1 = "abc", word2 = ""
// dp[1][0] = 1 // delete 'a'
// dp[2][0] = 2 // delete 'a','b'
// dp[3][0] = 3 // delete 'a','b','c'
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

// Base case 2:
// Convert empty string to first j 
//chars of word2 → insert all j chars
// Example: word1 = "", word2 = "xy"
// dp[0][1] = 1 // insert 'x'
// dp[0][2] = 2 // insert 'x','y'
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

// Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
 // Characters match, no operation needed
                    dp[i][j] = dp[i-1][j-1];
                } else {
// Characters mismatch:
// Minimum of:
// 1. Replace word1[i-1] with 
//word2[j-1] → dp[i-1][j-1] + 1
// 2. Delete word1[i-1] → dp[i-1][j] + 1
// 3. Insert word2[j-1] → dp[i][j-1] + 1
                    dp[i][j] = Math.min(
                        dp[i-1][j-1],           // replace
                        Math.min(
                            dp[i-1][j],         // delete
                            dp[i][j-1]          // insert
                        )
                    ) + 1;
                }
            }
        }

// Minimum operations to convert full word1 -> word2
        return dp[m][n];
    }
}



// Time = O(m × n)
// Space = O(m × n)