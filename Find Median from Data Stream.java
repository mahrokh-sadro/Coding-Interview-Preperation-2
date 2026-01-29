The median is the middle value in an ordered 
integer list. If the size of the list is even,
there is no middle value, and the median is
the mean of the two middle values.

For example, for arr = [2,3,4], the
median is 3.
For example, for arr = [2,3], the
median is (2 + 3) / 2 = 2.5.

Implement the MedianFinder class:

MedianFinder() initializes the 
MedianFinder object.
void addNum(int num) adds the 
integer num from the data stream to the data structure.
double findMedian() returns the
median of all elements so far.
Answers within 10-5 of the actual 
answer will be accepted.

-10^5 <= num <= 10^5
There will be at least one element in
the data structure before calling findMedian.
At most 5 * 10^4 calls will be made to
addNum and findMedian.
class MedianFinder {
    
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        max=new PriorityQueue<>((a,b)->b-a);
        min=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if(max.size()<min.size()){
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size()>min.size()){
            return max.peek();
        }
        return (max.peek()+min.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 
//  If all integers are in range [0, 100]:
// Use a counting array of size 101.
// Insertion: O(1) — increment count[num].
// Median: O(1) — scan the array to find 
// the median position(s).
// If 99% of integers are in range [0, 100]:
// Use a counting array for [0, 100] plus a
// heap (or sorted list) for outliers.
// Insertion: O(1) for in-range, O(log n) 
// for outliers.
// Median: O(1) — compute from the counting 
// array, accounting for outliers if needed.
// This handles the common case efficiently
// while supporting rare outliers.