// You are given an integer mountain 
// array arr of length n where the 
// values increase to a peak element and then decrease.
// Return the index of the peak element.
// Your task is to solve it in O(log(n))
// time complexity.
// 3 ≤ arr.length ≤ 10^5
// 0 ≤ arr[i] ≤ 10^6
// arr is guaranteed to be a mountain array.
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l=0;
        int r=arr.length-1;

        while(l<r){
            int mid=l+(r-l)/2;
//If arr[mid] < arr[mid + 1], you’re on the
// ascending slope → peak is to the right
            if(arr[mid]<arr[mid+1]){
              l=mid+1;
            }
            else{
//Else, you’re on the descending slope or at 
//the peak → peak is at mid or to the left
                r=mid;
            }
        }
//Loop ends when l == r, which is the peak index
        return l;
    }
}
//Time: O(log n)
//Space: O(1)