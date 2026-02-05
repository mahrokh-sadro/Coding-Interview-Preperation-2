// You are given an m x n grid where 
// each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.

// Every minute, any fresh orange that
// is 4-directionally adjacent to a rotten
// orange becomes rotten.
// Return the minimum number of minutes 
// that must elapse until no cell has a
// fresh orange. If this is impossible, return -1.

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.

class Solution {
    public int orangesRotting(int[][] grid) {
        int freshCount=0;
        Queue<int[]> queue=new LinkedList<>();
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                   freshCount++;
                }
                else if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        if(freshCount==0){
            return 0;
        }

        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        int mins=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] rotton=queue.poll();
                for(int[] dir:directions){
                    int x=rotton[0]+dir[0];
                    int y=rotton[1]+dir[1];
                    if(x>=0 && x<rows && y>=0 && y<cols && grid[x][y]==1 ){
                    grid[x][y]=2;
                    freshCount--;
                    queue.add(new int[]{x,y});
                    }

                }
            }
            mins++;
        }

        if(freshCount!=0) return -1;
        return mins-1;
    }
}
// Time: O(n × m)
// Space: O(n × m)


