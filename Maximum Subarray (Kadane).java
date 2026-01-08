// Given an integer array nums, find the subarray with
// the largest sum, and return its sum.
// Constraints:
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4

public int maxSubArray(int[] nums){
    int n = nums.length;

    // Constraint ensures at least one element
    if (n == 1) {
        return nums[0];
    }

    int cur = nums[0];
    int max = nums[0];

    // Kadane's Algorithm
    for (int i = 1; i < n; i++) {
        cur = Math.max(nums[i], nums[i] + cur);
        max = Math.max(max, cur);
    }

    return max;
}

// Time Complexity: O(n)
// Space Complexity: O(1)
