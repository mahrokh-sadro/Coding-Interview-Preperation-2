// Check if Array is Sorted

public boolean isSorted(int[] nums){
    int n=nums.length;
    if(n<2){
        return true;
    }
    for(int i=1;i<n;i++){
        if(nums[i]<nums[i-1]){
            return false;
        }
    }
    return true;
}

// time
//o(n)
// space
//o(1)