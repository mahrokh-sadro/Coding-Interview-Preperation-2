// Given an integer array nums and an
// integer k, return the k most frequent
// elements. You may return the answer
// in any order.

// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// k ∈ [1, #unique elements]
// Answer is unique
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->map.get(a)-map.get(b)
        );

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(entry.getKey());
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] array=new int[pq.size()];
        int j=0;
        while(!pq.isEmpty()){
           array[j++]=pq.poll();
        }
        return array;
    }
}

// Time	O(n log k)
// Space	O(n)