// Given an integer array nums, find a
// subarray that has the largest product,
// and return the product.

// The test cases are generated so that
// the answer will fit in a 32-bit integer.

// Note that the product of an array with
// a single element is the value of that element.
// 1 <= nums.length <= 2 * 10^4
// -10 <= nums[i] <= 10
// The product of any subarray of nums 
// is guaranteed to fit in a 32-bit integer

class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }

        int left=nums[0];
        int right=nums[n-1];
        int max=Math.max(left,right);
        for(int i=1;i<n;i++){
            left=left==0?nums[i]:nums[i]*left;
            right=right==0?nums[n-i-1]:nums[n-i-1]*right;
            max=Math.max(max,Math.max(left,right));
        }
        return max;
    }
}

// Time: O(n)
// Space: O(1)