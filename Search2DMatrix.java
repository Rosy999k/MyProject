/*
naive - linear traversal O(mn) space o(1)
better - binary search on each row O(nlogm)
optimal - top right corner o(m+n)
best - time log(mn) space o(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int left = 0, rows = matrix.length, cols = matrix[0].length;
        int right = rows * cols -1;int pivot = 0;
        while(left <= right) {
            int mid = (left+right)/2;
            pivot = matrix[mid/cols][mid%cols];
            if(pivot == target) return true;
            if(pivot < target) {
                left = mid+1;
            }
            else
            {
                right =mid-1;
            }
        }
        return false;
    }
}