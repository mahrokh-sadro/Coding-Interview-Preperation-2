// Given an integer array nums of length 
// n where all the integers of nums are
// in the range [1, n] and each integer
// appears at most twice, return an array
// of all the integers that appears twice.

// You must write an algorithm that runs 
// in O(n) time and uses only constant 
// auxiliary space, excluding the space 
// needed to store the output

// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n
// Each element in nums appears once or twice.
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i=0;
        int n=nums.length;
        while(i<n){
            int expectedIndex=nums[i]-1;
            if( nums[i]!=nums[expectedIndex]){
               int temp=nums[i];
               nums[i]=nums[expectedIndex];
               nums[expectedIndex]=temp;
            }
            else{
                i++;
            }
        }
        
        List<Integer> list=new ArrayList<>();
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
               list.add(nums[j]);
            }
        }
        return list;
    }
}
//Time:o(n)
//Space:o(1)