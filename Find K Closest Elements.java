// Given a sorted integer array arr, two
// integers k and x, return the k closest
// integers to x in the array. The result
// should also be sorted in ascending order.
// An integer a is closer to x than an integer b if:

// |a - x| < |b - x|, or
// |a - x| == |b - x| and a < b

// 1 ≤ k ≤ arr.length
// 1 ≤ arr.length ≤ 10^4
// arr is sorted in ascending order.
// -10^4 ≤ arr[i], x ≤ 10^4
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]==b[1]?a[0]-b[0]    :a[1]-b[1]);
        //int[] num,diff
        for(int num:arr){
            pq.add(new int[]{num,Math.abs(x-num)});
        }
  
        List<Integer> list=new ArrayList<>();
        while(!pq.isEmpty() && k>0){
            var polled=pq.poll();
            System.out.println(polled[0]+","+polled[1]);
            list.add(polled[0]);
            k--;
        }
        Collections.sort(list);
        return list;
    }
}
// Time: O(log(n - k) + k)
// Space: O(k)
class Solution {
    
    // Approach:
    // Using two pointers, we are going the 'start' and 'end' pointers towards each other,
    // until only k elements between 'start' and 'end'.
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int start = 0;
        int end = arr.length - 1;
        // Between the 'start' and 'end' pointers, inclusive, contains all the k integers that is closest to x.
        while (end - start >= k) {
            // Move 'start' to the right if 'end' is closer to x, or move 'end' to the left if 'start' is closer to x.
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++;
            } else {
                end--;
            }
        }

        // Input all the k closest integers into the result.
        List<Integer> result = new ArrayList<>(k);
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
//Time:O(n)
//Space:O(1)

