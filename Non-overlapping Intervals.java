// Given an array of intervals intervals
// where intervals[i] = [starti, endi],
// return the minimum number of intervals
// you need to remove to make the rest 
// of the intervals non-overlapping.

// Note that intervals which only touch 
// at a point are non-overlapping. For 
// example, [1, 2] and [2, 3] are non-overlapping.

// 1 <= intervals.length <= 10^5
// intervals[i].length == 2
// -5 * 10^4 <= start_i < end_i <= 5 * 10^4
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        List<int[]> merge=new ArrayList<>();
        merge.add(intervals[0]);
        int count=0;
        for(int i=1;i<intervals.length;i++){
            int[] cur=intervals[i];
            int[] pre=merge.get(merge.size()-1);
            if(pre[1]>cur[0]){
               count++;
            }
            else{
                merge.add(intervals[i]);
            }
        }
        return count;
    }
}
// Time: O(n log n)
// Space: O(n)