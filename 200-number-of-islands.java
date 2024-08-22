/*
https://leetcode.com/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-interview-150
*/


class Solution {
    boolean[][] visited;
    int[] row;
    int[] col;

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];
        row = new int[]{1, -1};
        col = new int[]{1, -1};

        int islands = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    islands++;
                    findIslands(grid, i, j);
                }
            }
        }

        return islands;
    }

    public void findIslands(char[][] grid, int i, int j){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j]=='0')
            return;
        
        if(visited[i][j])
            return;

        visited[i][j] = true;

        findIslands(grid, i-1, j);
        findIslands(grid, i+1, j);
        findIslands(grid, i, j+1);
        findIslands(grid, i, j-1);

        return;
    }
}
