// Given an integer array nums, return 
// all the triplets [nums[i], nums[j],
// nums[k]] such that i != j, i != k,
// and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must 
// not contain duplicate triplets.

// 3 <= nums.length <= 3000
// -10^5 <= nums[i] <= 10^5
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
           int l=i+1;
           int r=n-1;
           while(l<r){
              int sum=nums[i]+nums[l]+nums[r];
              if(sum==0){
                 list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                 while(l<r && nums[l]==nums[l+1]) l++;
                 while(l<r && nums[r]==nums[r-1])r--;

                  l++;
                  r--;
              }
              else if(sum<0){
                 l++;
              }
              else{
                 r--;
              }
           }
        }
        return list;
    }
}
// Time : O(n^2)
// Space : O(n) 

