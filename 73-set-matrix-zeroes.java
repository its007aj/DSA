/*
https://leetcode.com/problems/set-matrix-zeroes/description/
*/


class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int col = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==0) {
                    if(j==0) {
                        matrix[i][0] = 0;
                        col = 0;
                    }
                    else {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;   
                    }
                }
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        // 0th row
        for(int j=1; j<m; j++){
            if(matrix[0][j]!=0 && matrix[0][0]==0){
                matrix[0][j] = 0;
            }
        }

        // 0th column
        for(int i=0; i<n; i++){
            if(matrix[i][0]!=0 && col==0){
                matrix[i][0] = 0;
            }
        }

    }
}
