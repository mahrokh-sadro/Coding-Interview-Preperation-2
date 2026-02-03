// Given an integer array nums, return
// the length of the longest strictly increasing .

// - 1 ≤ nums.length ≤ 2500
// - −10^4 ≤ nums[i] ≤ 10^4
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int l=0,r=list.size()-1;
            int num=nums[i];
            while(l<=r){
               int mid=l+(r-l)/2;
               if(list.get(mid)<num){
                  l=mid+1;
               }
               else{
                  r=mid-1;
               }
            }

            if(list.size()==l){
               list.add(num);
            }
            else{
               list.set(l,num);
            }
        }
        return list.size();
    }
}
// Time : O(n log n)
// Space : O(n)
