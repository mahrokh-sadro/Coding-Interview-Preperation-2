// You are given two lists of closed 
// intervals, firstList and secondList,
// where firstList[i] = [starti, endi]
// and secondList[j] = [startj, endj].
// Each list of intervals is pairwise 
// disjoint and in sorted order.

// Return the intersection of these 
// two interval lists.

// A closed interval [a, b] (with a <= b)
// denotes the set of real numbers x with a <= x <= b.

// The intersection of two closed intervals
// is a set of real numbers that are either
// empty or represented as a closed interval.
// For example, the intersection of [1, 3]
// and [2, 4] is [2, 3].

// - 0 <= firstList.length, secondList.length <= 1000
// - firstList.length + secondList.length >= 1
// - 0 <= starti < endi <= 10^9
// - endi < start(i+1)   // intervals are sorted and non-overlapping
// - 0 <= startj < endj <= 10^9
// - endj < start(j+1)   // intervals are sorted and non-overlapping
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> list=new ArrayList<>();
        int i=0;
        int j=0;
        int firstLength=firstList.length;
        int secondLength=secondList.length;

        while(i<firstLength && j<secondLength){
            int[] cur=new int[2];
            cur[0]=Math.max(firstList[i][0],secondList[j][0]);
            cur[1]=Math.min(firstList[i][1],secondList[j][1]);

            if(cur[0]<=cur[1]){
                list.add(cur);
            }
            if(firstList[i][1]<secondList[j][1]){
                i++;
            }
            else{
                j++;
            }
        }

        int[][] array=new int[list.size()][2];
        for(int k=0;k<list.size();k++){
            array[k]=list.get(k);
        }

        return array;
    }
}

// Time	O(m + n)
// Space	O(m + n) (for output), O(1) auxiliary