// Given a string s representing a valid 
// expression, implement a basic calculator
// to evaluate it, and return the result of the evaluation.

// Note: You are not allowed to use any
// built-in function which evaluates strings 
// as mathematical expressions, such as
// eval().- 1 ≤ s.length ≤ 3 × 10^5
// - s consists of digits, '+', '-', 
// '(', ')', and spaces ' '
// - s represents a valid expression
// - '+' is **not** used as a unary operator
// (e.g., "+1" and "+(2 + 3)" are invalid)
// - '-' **can** be used as a unary operator
// (e.g., "-1" and "-(2 + 3)" are valid)
// - No two consecutive operators appear in
// the input
// - Every number and intermediate result
// fits in a signed 32-bit integer
class Solution {
    public int calculate(String s) {
        int num=0;
        int result=0;
        int sign=1;
        Stack<Integer> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
               num=10*num+(ch-'0');
            }
            else if(ch=='+'){
               result+=num*sign;
               num=0;
               sign=1;
            }
            else if(ch=='-'){
               result+=num*sign;
               num=0;
               sign=-1;
            }
            else if(ch=='('){
                stack.add(result);
                stack.add(sign);

                result=0;
                sign=1;
            }
            else if(ch==')'){
                result+=num*sign;
                num=0;
                result*=stack.pop();
                result+=stack.pop();
            }
        }
        result+=num*sign;
        return result;
    }
}

//Time:O(n)
//Space:O(n)