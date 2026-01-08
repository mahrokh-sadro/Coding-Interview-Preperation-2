// Find Min and Max
public int[] findMinAndMax(int[] nums) {
    int n = nums.length;

    // Edge case: empty array
    if (n == 0) {
        return new int[0];
    }

    // Initialize min and max
    int min = nums[0];
    int max = nums[0];

    // Traverse once
    for (int num : nums) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }

    return new int[]{min, max};
}
