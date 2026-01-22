// Given n non-negative integers 
// representing an elevation map 
// where the width of each bar is
// 1, compute how much water it can
// trap after raining.

// n == height.length
// 1 ≤ n ≤ 2 × 10⁴
// 0 ≤ height[i] ≤ 10⁵
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] lmax=new int[n];
        lmax[0]=height[0];
        for(int i=1;i<n;i++){
            lmax[i]=Math.max(lmax[i-1],height[i]);
        } 

        int rmax=height[n-1];

        int ans=0;
        for(int j=n-1;j>=0;j--){
            rmax=Math.max(rmax,height[j]);
            ans+=Math.min(lmax[j],rmax)-height[j];
        }
        return ans;
    }
}
// Time: O(n) 
// Space: O(1)
