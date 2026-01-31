// Given an array of intervals where 
// intervals[i] = [starti, endi], merge
// all overlapping intervals, and return
// an array of the non-overlapping 
// intervals that cover all the intervals in the input.

// 1 ≤ intervals.length ≤ 10^4
// intervals[i].length == 2
// 0 ≤ start_i ≤ end_i ≤ 10^4
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> merged=new ArrayList<>();
        merged.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] cur=intervals[i];
            int[] pre=merged.get(merged.size()-1);
            
            if(pre[1]>=cur[0]){
              pre[1]=Math.max(pre[1],cur[1]);
            }
            else{
              merged.add(cur);
            }
        }
        
        int[][] array=new int[merged.size()][2];
        for(int i=0;i<merged.size();i++){
            array[i]=merged.get(i);
        }
        
        return array;
    }
}
// Time : O(n log n)
// Space : O(n)
