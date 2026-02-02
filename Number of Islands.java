// Given an m x n 2D binary grid grid 
// which represents a map of '1's
// (land) and '0's (water), return
// the number of islands.

// An island is surrounded by water 
// and is formed by connecting adjacent
// lands horizontally or vertically.
// You may assume all four edges of 
// the grid are all surrounded by water.

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,int r,int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]!='1'){
            return;
        }

        grid[r][c]='0';
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}

// Time: O(m × n)
// Space: O(m × n) due to recursion stack