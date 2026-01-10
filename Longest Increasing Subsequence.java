// Given an integer array nums, return the length of
// the longest strictly increasing subsequence.
// 1 <= nums.length <= 2500
// -10^4 <= nums[i] <= 10^4

public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    if (n < 2) return n; 
    
    List<Integer> list = new ArrayList<>(); 
// 'list' will store the smallest possible tail of increasing subsequences of each length
// list[i] = minimum possible ending number of an increasing subsequence of length i+1
    for (int num : nums) {
    // Binary search to find the first element in 'list' >= num
    // This is the position where 'num' can replace an existing tail
        int l = 0, r = list.size() - 1;  
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < num) {
                l = mid + 1; // num is bigger → look right
            } else {
                r = mid - 1; // num is smaller or equal → look left
            }
        }
    // After the loop, 'l' is the correct position for 'num'
        if (l == list.size()) {
            // num is greater than all current tails → extend the list
            list.add(num);
        } else {
        // num can replace list[l] to make a smaller tail
        // This helps future numbers to form longer increasing subsequences
            list.set(l, num);
        }
    }
// The size of 'list' = length of the Longest Increasing Subsequence
    return list.size();
}
// Time: O(n log n)
// Space: O(n)

