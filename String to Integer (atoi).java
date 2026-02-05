// Implement the myAtoi(string s) function,
// which converts a string to a 32-bit signed integer.

// The algorithm for myAtoi(string s) is as
// follows:

// Whitespace: Ignore any leading whitespace (" ").
// Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
// Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
// Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.

// Return the integer as the final result.

class Solution {
    public int myAtoi(String s) {
        int min=Integer.MIN_VALUE;//-2147483648
        int max=Integer.MAX_VALUE;//2147483647
        int sign=1;
        int num=0;
        String str=s.trim();
        boolean isDone=false;

        for(int i=0;i<str.length() && !isDone;i++){
            char ch=str.charAt(i);
           if(i==0 && ch=='+'){
                sign=1;
           }
           else if(i==0 && ch=='-'){
                sign=-1;
           }
           else if(Character.isDigit(ch)){
              int digit = ch - '0';

                // 🔹 FIXED overflow conditions ONLY
                if (sign == 1) {
                    if (num > max / 10 || (num == max / 10 && digit > 7)) {
                        return max;
                    }
                } else {
                    if (num > max / 10 || (num == max / 10 && digit >= 8)) {
                        return min;
                    }
                }
                                num = num * 10 + digit;
           }
           else{
              isDone=true;
           }
        }
       
        return num*sign;
    }

}


// Input: s = "42"
// Output: 42

// Input: s = " -042"
// Output: -42

// Input: s = "1337c0d3"
// Output: 1337

// Input: s = "0-1"
// Output: 0

// Input: s = "words and 987"
// Output: 0

// 0 <= s.length <= 200
// s consists of English letters 
// (lower-case and upper-case), digits 
// (0-9), ' ', '+', '-', and '.'.
