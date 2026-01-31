// Given an integer array nums, return
// an array answer such that answer[i]
// is equal to the product of all the
// elements of nums except nums[i].

// The product of any prefix or suffix
// of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that 
// runs in O(n) time and without using
// the division operation.
// 2 ≤ nums.length ≤ 10^5
// -30 ≤ nums[i] ≤ 30
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        pre[0]=1;
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]*nums[i-1];
        }

        int postfix=1;
        for(int j=n-1;j>=0;j--){
            pre[j]*=postfix;
            postfix*=nums[j];
        }

        return pre;
    }
}
//time:o(n)
//sapce:o(n)