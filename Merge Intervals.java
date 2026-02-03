// Given an array of intervals where
// intervals[i] = [starti, endi], merge
// all overlapping intervals, and
// return an array of the non-overlapping
// intervals that cover all the intervals in the input.

// - 1 ≤ intervals.length ≤ 10^4
// - intervals[i].length == 2
// - 0 ≤ start_i ≤ end_i ≤ 10^4
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> merge=new ArrayList<>();
        merge.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] cur=intervals[i];
            int[] pre=merge.get(merge.size()-1);

            if(pre[1]>=cur[0]){
              pre[1]=Math.max(pre[1],cur[1]);
            }
            else{
              merge.add(intervals[i]);
            }
        }

        int[][] array=new int[merge.size()][2];
        for(int j=0;j<merge.size();j++){
           array[j]=merge.get(j);
        }
        return array;

    }
}
// Time	O(n log n)
// Space	O(n)
