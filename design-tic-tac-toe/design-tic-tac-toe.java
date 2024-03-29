class TicTacToe {

    private int[][] board;
    private int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        this.board[row][col] = player;
        if (checkForVictory(player, row, col)) {
            return player;
        }
        
        return 0;
    }
    
    private boolean checkForVictory(int player, int row, int column) {
        if (checkRow(row, player) || checkColumn(column, player) ||
           (row == column && checkDiagonal(player)) || 
           (column == this.n - row - 1 && checkAntiDiagonal(player))) {
            return true;
        }
        
        return false;
    }
    
    private boolean checkRow(int row, int player) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] != player) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean checkColumn(int column, int player) {
        for (int i = 0; i < n; i++) {
            if(board[i][column] != player) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean checkDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean checkAntiDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][n - i - 1] != player) {
                return false;
            }
        }
        
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
    0 0 0 0 
    0 0 0 0 
    0 0 0 0 
    0 0 0 0 
 */