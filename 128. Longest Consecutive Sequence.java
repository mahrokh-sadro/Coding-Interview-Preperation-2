// Given an unsorted array of integers 
// nums, return the length of the longest 
// consecutive elements sequence.

// You must write an algorithm that
// runs in O(n) time.
// 0 ≤ nums.length ≤ 10^5
// -10^9 ≤ nums[i] ≤ 10^9
class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        int maxLength=0;
        for(int i=0;i<n;i++){
            int curLength=1;
            int num=nums[i];

            while(set.contains(++num)){
                curLength++;
                set.remove(num);
            }

            num=nums[i];
            while(set.contains(--num)){
                curLength++;
                set.remove(num);
            }

            maxLength=Math.max(maxLength,curLength);
        }
        return maxLength;

    }
}
//time:o(n)
//space:o(n)