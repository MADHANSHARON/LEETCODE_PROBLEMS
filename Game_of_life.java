class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                setAns(i, j, board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==3){
                    board[i][j]=1;
                }
                else if(board[i][j]==4){
                    board[i][j]=0;
                }
            }
        }
    }
    
    public void setAns(int row, int col, int[][] board) {
        int countOne = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                
                int nrow = row + i;
                int ncol = col + j;
                
                if (nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length) {
                    if (board[nrow][ncol] == 1 || board[nrow][ncol] == 4) {
                        countOne++;
                    }
                }
            }
        }
        
        if (board[row][col] == 0 && countOne == 3) {
            board[row][col] = 3;
        } 
        else if(board[row][col] == 1 && countOne>3) {
            board[row][col] = 4;
        }
        else if(board[row][col] == 1 && countOne<2) {
            board[row][col] = 4;
        }
    }
}