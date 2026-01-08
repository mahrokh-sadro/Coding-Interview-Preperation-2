//Find Second Largest Element

public int findSecondLargest(int[] nums) {
    if (nums == null || nums.length < 2) {
        throw new IllegalArgumentException("Array must have at least 2 elements");
    }
    
    int max = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    
    for (int num : nums) {
        if (num > max) {    
            secondLargest = max; 
            max = num;
        } else if (num > secondLargest && num < max) { 
            secondLargest = num; 
        }
    }
    return secondLargest;
}

// time 
//o(n)
// space 
//o(1)