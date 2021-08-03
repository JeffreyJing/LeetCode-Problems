class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    removeLand(grid, row, column);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void removeLand(char[][] grid, int row, int column) {
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length) {
            if (grid[row][column] == '1') {
                grid[row][column] = '0';
                removeLand(grid, row - 1, column);
                removeLand(grid, row + 1, column);
                removeLand(grid, row, column - 1);
                removeLand(grid, row, column + 1);
            }
        }
    }
}