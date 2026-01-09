// Given an unsorted array of integers nums,
// return the length of the longest consecutive
// elements sequence.
// You must write an algorithm that runs in O(n) time.
// 0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9

public int longestConsecutive(int[] nums){
    int n=nums.length;
    if(n<2){
        return n;
    }
    
    Set<Integer> set=new HashSet<>();
    for(int num:nums){
        set.add(num);
    }
    
    int maxLen=0;
    for(int i=0;i<n;i++){
        int num=nums[i];
        int count=1;
        
        while(set.contains(++num)){
            count++;
            set.remove(num);
        }
        
        num=nums[i];
        while(set.contains(--num)){
            count++;
            set.remove(num);
        }
        maxLen=Math.max(maxLen,count);
    }
    return maxLen;
}

//Time 
// o(n)
//Space 
// o(n)

