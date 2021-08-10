class Solution {
    private boolean wordCompleted;
    public boolean exist(char[][] board, String word) {
        if (board.length == 1 && board[0].length == 1) {
            return board[0][0] == word.charAt(0) && word.length() == 1;    
        }
        
        this.wordCompleted = false;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == word.charAt(0)) {
                    dfs(board, word, row, column, 0);
                    if (wordCompleted) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private void dfs(char[][] board, String word, int row, int column, int wordIndex) {
        // check if board[row][column] represents a valid position on the board
        if (row >= 0 && column >= 0 && row < board.length && column < board[0].length) {
            // case where every character in word was found
            if (wordIndex == word.length()) {
                this.wordCompleted = true;
            } else if (board[row][column] == word.charAt(wordIndex)) {
                char currentChar = board[row][column];
                board[row][column] = '1';
                dfs(board, word, row + 1, column, wordIndex + 1);
                dfs(board, word, row - 1, column, wordIndex + 1);
                dfs(board, word, row, column + 1, wordIndex + 1);
                dfs(board, word, row, column - 1, wordIndex + 1);
                board[row][column] = currentChar;
            }
        }
    }
}