// Given an array of integers temperatures
// represents the daily temperatures, 
// return an array answer such that answer[i]
// is the number of days you have to wait
// after the ith day to get a warmer
// temperature. If there is no future
// day for which this is possible,
// keep answer[i] == 0 instead.

// 1 ≤ temperatures.length ≤ 10⁵
// 30 ≤ temperatures[i] ≤ 100
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> stack=new Stack<>();
        int[] array=new int[n];
        // int j=0;
        for(int i=0;i<n;i++){
           while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
               int index=stack.pop();
               array[index]=i-index;
           }
           stack.push(i);
        }
        return array;
    }
}
// Time : O(n)
// Space : O(n)