// Given an array of integers nums and an integer k,
// return the total number of subarrays whose sum
// equals to k.
// A subarray is a contiguous non-empty sequence
// of elements within an array.
// 1 <= nums.length <= 2 * 10^4
// -1000 <= nums[i] <= 1000
// -10^7 <= k <= 10^7

public int subarraySum(int[] nums, int k) {
    // why Map?
    // We store prefix sums and how many times each has appeared
    // because the same prefix sum can occur multiple times
    Map<Integer, Integer> map = new HashMap<>();
    // why put (0, 1)?
    // This represents a prefix sum of 0 before the array starts
    // It allows counting subarrays that start at index 0
    map.put(0, 1);
    int count = 0;
    int sum = 0;
    for (int num : nums) {
        // Running prefix sum up to current index
        sum += num;
        // why sum - k, not sum?
        // Because subarray sum = currentSum - previousSum
        // To get subarray sum = k:
        // previousSum must be (currentSum - k)
        if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
        }
        // why put sum, not sum - k?
        // We store the CURRENT prefix sum so future elements
        // can use it to form subarrays
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // why check BEFORE put?
        // Because we must only use prefix sums from earlier indices
        // Putting first would count the current index as a subarray start
    }

    return count;
}

//time
//o(n)
//space
//o(n)