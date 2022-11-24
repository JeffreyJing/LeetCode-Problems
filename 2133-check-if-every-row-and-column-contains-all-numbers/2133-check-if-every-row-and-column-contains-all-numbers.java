class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            int[] countRow = new int[n];
            int[] countColumn = new int[n];
            for (int j = 0; j < n; j++) {
                if (countRow[matrix[i][j]-1] == 1 || countColumn[matrix[j][i]-1] == 1)
                    return false;
                countRow[matrix[i][j] - 1]++;
                countColumn[matrix[j][i] - 1]++;
            }
        }
        return true;
    }
}