// You are given a string s consisting of
// lowercase English letters. A duplicate 
// removal consists of choosing two adjacent
// and equal letters and removing them.

// We repeatedly make duplicate removals 
// on s until we no longer can.

// Return the final string after all such
// duplicate removals have been made. It
// can be proven that the answer is unique.

// 1 <= s.length <= 10^5
// s consists of lowercase English letters.
class Solution {
    public String removeDuplicates(String s) {
        int n=s.length();
        if(n==1){
            return s;
        }

        Stack<Character> stack=new Stack<>(); 
        for(char ch:s.toCharArray()){
           if(!stack.isEmpty() && stack.peek()==ch){
             stack.pop();
           }
           else{
            stack.push(ch);
           }
        }

        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
//Time:O(n)
//Space:O(n)



