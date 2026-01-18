// Given a string s representing a valid
// expression, implement a basic calculator
// to evaluate it, and return the result
// of the evaluation.

// Note: You are not allowed to use any
// built-in function which evaluates 
// strings as mathematical expressions, such as eval().

// 1 <= s.length <= 3 * 105
// s consists of digits, '+', '-', '(', ')',
// and ' '.
// s represents a valid expression.
// '+' is not used as a unary operation 
// (i.e., "+1" and "+(2 + 3)" is invalid).
// '-' could be used as a unary operation 
// (i.e., "-1" and "-(2 + 3)" is valid).
// There will be no two consecutive operators
// in the input.
// Every number and running calculation will
// fit in a signed 32-bit integer.

class Solution {
    public int calculate(String s) {
// Stack to store context when we enter parentheses:
// we push the current result and the sign before '('
        Stack<Integer> stack = new Stack<>();
// running total result
        int result = 0;
// current sign for the number we are about to read (+1 or -1)
        int sign = 1;
// current number being read (can be multi-digit)
        int num = 0;
// loop over each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
  // build multi-digit number
                num = num * 10 + (ch - '0');
            } 
            else if (ch == '+') {
  // commit the previous number with its sign
                result += sign * num;
  // reset num
                num = 0;
  // update sign for next number
                sign = 1; 
            } 
            else if (ch == '-') {
  // commit the previous number with its sign
                result += sign * num;
  // reset num
                num = 0;
 // update sign for next number
                sign = -1;
            } 
            else if (ch == '(') {
// push current result and sign onto stack to save context
                stack.push(result);
                stack.push(sign);
    // reset result and sign for new parentheses context
                result = 0;
                sign = 1;
            } 
            else if (ch == ')') {
    // first, commit the number inside parentheses
                result += sign * num;
                num = 0;
    // multiply the result inside parentheses by the sign before '('
                result *= stack.pop(); // previous sign
   // add the result before '(' to get total
                result += stack.pop(); // previous result
            }
   // spaces are ignored automatically
        }
 // add the last number if any
        result += sign * num;

        return result;
    }
}

//Time:O(n)
//Space:O(n)