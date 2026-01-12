// Given two strings s and t of lengths m
// and n respectively, return the minimum
// window substring of s such that every 
// character in t (including duplicates)
// is included in the window. If there is
// no such substring, return the empty string "".

// The testcases will be generated such
// that the answer is unique.
// m == s.length
// n == t.length
// 1 <= m, n <= 10^5
// s and t consist of uppercase and
// lowercase English letters.
class Solution {
    public String minWindow(String s, String t) {
// If s is shorter than t, it's
// impossible to have a valid window
        if (s.length() < t.length()) 
            return "";

// minStart: starting index of the minimum window found
// l, r: left and right pointers of the sliding window
        int minStart = 0, l = 0, r = 0;

// minLen: length of the minimum
// window found, initialized to "infinity"
        int minLen = Integer.MAX_VALUE;

// count: number of characters from
// t we still need to match
        int count = t.length();

// arr: frequency array for 
//characters in t
// Using ASCII size 128 (s and t
// consist of English letters)
        int[] arr = new int[128];

// Populate the frequency array 
//with characters from t
        for (char ch : t.toCharArray()) {
            arr[ch]++;
        }

// Slide the right pointer through 
//the string s
        while (r < s.length()) {
            char rchar = s.charAt(r);

// If this character is needed 
//(frequency > 0), we decrease the remaining count
            if (arr[rchar] > 0) {
                count--;
            }

// Decrement the frequency in arr
// (can go negative if char occurs more than needed)
            arr[rchar]--;

// Move the right pointer forward
            r++;

    // When all required characters
    // are included in the current window
            while (count == 0) {
    // If the current window is 
    //smaller than the previous
    // minimum, update minLen and minStart
                if (r - l < minLen) {
                    minLen = r - l;
                    minStart = l;
                }

                char lchar = s.charAt(l);

// Increment the frequency 
//of the leftmost character as we are about 
//to remove it from window
                arr[lchar]++;

// If this character was required,
// increment count because window now misses a needed char
                if (arr[lchar] > 0) {
                    count++;
                }

// Move the left pointer forward
// to try and shrink the window
                l++;
            }
        }

// If minLen wasn't updated, return
// empty string, otherwise return the minimum window substring
        return minLen == Integer.MAX_VALUE ? "" :
         s.substrin(minStart, minStart + minLen);
    }
}

//Time:O(m + n) → O(m)
//Space:O(1)
