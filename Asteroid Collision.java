// We are given an array asteroids of 
// integers representing asteroids in 
// a row. The indices of the asteroid 
// in the array represent their relative
// position in space.

// For each asteroid, the absolute value
// represents its size, and the sign 
// represents its direction (positive
// meaning right, negative meaning left).
// Each asteroid moves at the same speed.

// Find out the state of the asteroids 
// after all collisions. If two asteroids
// meet, the smaller one will explode. If
// both are the same size, both will explode.
// Two asteroids moving in the same 
// direction will never meet.
// 2 <= asteroids.length <= 10^4
// -1000 <= asteroids[i] <= 1000
// asteroids[i] != 0

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int a:asteroids){
            boolean alive=true;
            while(alive && a<0 && !stack.isEmpty() && stack.peek()>0){
               if(stack.peek()<-a){
                 stack.pop();
               }
               else if(stack.peek()==-a){
                 stack.pop();
                 alive=false;
               }
               else{
                 alive=false;
               }   
            }
            if(alive){
                stack.push(a);
            }
        }
        int[] array=new int[stack.size()];
        int j=stack.size()-1;
        while(!stack.isEmpty()){
            array[j--]=stack.pop();
        }
        return array;
    }
}
// Time:  O(n)
// Space: O(n)
