// A peak element is an element that 
// is strictly greater than its neighbors.

// Given a 0-indexed integer array nums,
// find a peak element, and return its
// index. If the array contains multiple
// peaks, return the index to any of the peaks.

// You may imagine that nums[-1] = nums[n] = -∞.
// In other words, an element is always
// considered to be strictly greater than 
// a neighbor that is outside the array.

// You must write an algorithm that 
// runs in O(log n) time.
// 1 ≤ nums.length ≤ 1000
// -2^31 ≤ nums[i] ≤ 2^31 − 1
// nums[i] ≠ nums[i + 1] for all valid i
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        int l=0;
        int r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<nums[mid+1]){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
}
//time:o(log n)
//space:o(1)