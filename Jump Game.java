// You are given an integer array nums.
// You are initially positioned at the
// array's first index, and each element
// in the array represents your maximum 
// jump length at that position.

// Return true if you can reach the last
// index, or false otherwise.
// 1 <= nums.length <= 10^4
// 0 <= nums[i] <= 10^5

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
    //nums[i] = maximum jump length from index i
    //i + nums[i] = farthest index you can reach from position i
    //maxReach stores the farthest index reachable so far
    //At each index, we check if jumping from here gets us farther
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // can't reach this index
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}
