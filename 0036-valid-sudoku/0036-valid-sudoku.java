class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] digits = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (digits[board[i][j] - 49] != 0) {
                        return false;
                    }
                    
                    digits[board[i][j] - 49] = 1;
                }
            }
        }
        
        for (int i = 0; i < board[0].length; i++) {
            int[] digits = new int[9];
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    if (digits[board[j][i] - 49] != 0) {
                        return false;
                    }
                    
                    digits[board[j][i] - 49] = 1;
                }
            }
        }
        
        int col = 0;
        int row = 0;
        while (col < board.length) {
            while (row < board[0].length) {
                int[] digits = new int[9];
                for (int i = col; i < col + 3; i++) {
                    for (int j = row; j < row + 3; j++) {
                        if (board[i][j] != '.') {
                            if (digits[board[i][j] - 49] != 0) {
                                return false;
                            }
                                       
                            digits[board[i][j] - 49] = 1;
                        }
                    }
                }
                
                row += 3;
            }
            
            col += 3;
            row = 0;
        }
        
        return true;
    }
}