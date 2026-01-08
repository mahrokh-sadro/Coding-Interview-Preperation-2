// Given an array nums containing n distinct
// numbers in the range [0, n], return the
// only number in the range that is missing
// from the array.
// n == nums.length
// 1 <= n <= 104
// 0 <= nums[i] <= n

public int missingNumber(int[] nums) {
    int i = 0;
    int n = nums.length;
    // Place each number at its correct index if possible
    // Numbers should be in the range [0, n]
    while (i < n) {
        int expectedIndex = nums[i];
        // Only swap if:
        // 1. nums[i] is within bounds (0 to n-1)
        // 2. nums[i] is not already at its correct index
        if (nums[i] < n && nums[expectedIndex] != nums[i]) {
            int temp = nums[expectedIndex];
            nums[expectedIndex] = nums[i];
            nums[i] = temp;
        } else {
            // Move forward if no swap is needed
            i++;
        }
    }
    // After cyclic sort, the index where nums[index] != index
    // is the missing number
    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != j) {
            return j;
        }
    }
    // If all indices match, the missing number is n
    return n;
}

//time complexity
//o(n)
//space complexity
//o(1)

public int missingNumber(int[] nums) {
    int n=nums.length;
    int curSum=0;
    for(int num:nums){
        curSum+=num;
    }
    int expectedSum=n*(n+1)/2;
    return expectedSum-curSum;
}


