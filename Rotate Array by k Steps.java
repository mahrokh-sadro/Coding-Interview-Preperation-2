// Given an integer array nums, rotate the array to 
// the right by k steps, where k is non-negative.
// 1 <= nums.length <= 10^5
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105

public void rotate(int[] nums,int k){
    int n=nums.length;
    if(n==1 || k%n==0){
        return;
    }
    k=k%n;
    reverse(nums,0,n-1);
    reverse(nums,0,k-1);
    reverse(nums,k,n-1);
}

private void reverse(int[] nums,int l,int r){
    while(l<r){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
        l++;
        r--;
    }
}

//time 
//o(n)
//space 
//o(1)


