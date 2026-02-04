// Given an m x n grid of characters 
// board and a string word, return true
// if word exists in the grid.

// The word can be constructed from letters 
// of sequentially adjacent cells, where
// adjacent cells are horizontally or vertically
// neighboring. The same letter cell may not
// be used more than once.

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase 
// and uppercase English letters.
class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    if(board[i][j]==word.charAt(0) && 
                      dfs(board, word, i, j, visited,0)){
                        return true;
                      }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r,int c,  boolean[][] visited, int index){
        if(index==word.length()){
            return true;
        }
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || visited[r][c] 
           || board[r][c]!=word.charAt(index)){
              return false;
        }

        visited[r][c]=true;
        if(dfs(board, word, r+1, c, visited, index+1) ||
            dfs(board, word, r-1, c, visited, index+1) ||
            dfs(board, word, r, c+1, visited, index+1) ||
            dfs(board, word, r, c-1, visited, index+1) 
        ){
            return true;
        }
        visited[r][c]=false;
        return false;
    }
}

// Time: O(m × n × 4^L) because DFS 
//tries all possible paths for each cell
// Space: O(m × n) due to the visited
//matrix and recursion stack