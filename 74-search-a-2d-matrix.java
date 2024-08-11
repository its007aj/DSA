/*
https://leetcode.com/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int hi = n-1;
        int row = 0;

        //find row using binary search
        while(l<=hi){
            row = l+(hi-l)/2;
            System.out.println("gdhj");
            if(matrix[row][0]<=target && matrix[row][m-1]>=target)
                break;
            else if(target<matrix[row][0])
                hi = row-1;
            else if(target>matrix[row][m-1])
                l = row+1;
        }

        // find target in the selected row
        l = 0;
        hi = m-1;
        int mid = 0;
        while(l<=hi){
            mid = l+(hi-l)/2;
            if(matrix[row][mid]==target)
                return true;
            else if(matrix[row][mid]>target)
                hi = mid-1;
            else if(matrix[row][mid]<target)
                l = mid+1;
        }
        
        return false;
    }
}
