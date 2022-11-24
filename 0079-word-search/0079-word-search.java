class Solution {
    public boolean exist(char[][] board, String word) {
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[col].length; row++) {
                if (board[col][row] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (attemptSolve(board, visited, word, 0, row, col)) {
                        return true;
                    }                                        
                }
            }
        }
        
        return false;
    }
    
    private boolean attemptSolve(char[][] board, boolean[][] visited, String word, int count, int row, int col) {
        if (count == word.length()) {
            return true;
        }
        
        if (row < board[0].length && col < board.length && row >= 0 && col >= 0) {
            if (board[col][row] == word.charAt(count) && !visited[col][row]) {
                visited[col][row] = true;
                if (attemptSolve(board, visited, word, count + 1, row + 1, col) ||
                    attemptSolve(board, visited, word, count + 1, row - 1, col) ||
                    attemptSolve(board, visited, word, count + 1, row, col + 1) || 
                    attemptSolve(board, visited, word, count + 1, row, col - 1)) {
                        return true;
                }
                    
                visited[col][row] = false;
            }
        }
        
        return false;
    }
}