
// Given an integer array nums and an integer k,
// return the kth largest element in the array.
// Note that it is the kth largest element in
// the sorted order, not the kth distinct element.

// 1 <= k <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4

public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    for(int num:nums){
        pq.add(num);

        if(pq.size()>k){
            pq.poll();
        }
    }
    return pq.peek();
}

//Time 
// O(n log k)
//Space 
// O(k)


