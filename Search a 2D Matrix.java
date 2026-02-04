// You are given an m x n integer matrix 
// matrix with the following two properties:
// Each row is sorted in non-decreasing
// order.
// The first integer of each row is 
// greater than the last integer of the previous row.
// Given an integer target, return true 
// if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n))
// time complexity.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=getRow(matrix, target);
        if(row!=-1){
            return binary(matrix,target,row);
        }
        return false;
    }

    private boolean binary(int[][] matrix, int target,int row){
        int l=0;
        int r=matrix[0].length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(matrix[row][mid]==target){
                return true;
            }
            if(matrix[row][mid]<target){
               l=mid+1;
            }
            else{
               r=mid-1;
            }
        }
        return false;
    }

    private int getRow(int[][] matrix, int target){
        int l=0;
        int r=matrix.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(matrix[mid][0]<=target && target<=matrix[mid][matrix[0].length-1]){
               return mid; 
            }
            else if(target<matrix[mid][0]){
               r=mid-1;
            }
            else{
               l=mid+1;
            }
        }
        return -1;
    }
}
// Time:O(logm+logn)=O(log(m⋅n))
// Space:O(1)