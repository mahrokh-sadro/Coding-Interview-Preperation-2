// You are given an integer array height 
// of length n. There are n vertical
// lines drawn such that the two 
// endpoints of the ith line are (i, 0)
// and (i, height[i]).
// Find two lines that together with
// the x-axis form a container, such 
// that the container contains the most
// water.

// Return the maximum amount of water
// a container can store.

// Notice that you may not slant the
// container.

// n == height.length
// 2 <= n <= 10^5
// 0 <= height[i] <= 10^4
class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;
        int max=0;
        while(l<r){
           int curHeight=Math.min(height[l],height[r]);
           int cur=(r-l)*curHeight;
           max=Math.max(cur,max);

           if(height[l]<height[r]){
             l++;
           }
           else{
             r--;
           }
        }

        return max;
    }
}