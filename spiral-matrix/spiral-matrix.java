class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List spiralList = new ArrayList<Integer>();
        if (matrix.length != 0) {
            int r1 = 0;
            int r2 = matrix.length - 1;
            int c1 = 0;
            int c2 = matrix[0].length - 1;
            while (r1 <= r2 && c1 <= c2) {
                for (int c = c1; c <= c2; c++) {
                    spiralList.add(matrix[r1][c]);
                }
                
                for (int r = r1 + 1; r <= r2; r++) {
                    spiralList.add(matrix[r][c2]);
                }
                
                if (r1 < r2 && c1 < c2) {
                    for (int c = c2 - 1; c > c1; c--) {
                        spiralList.add(matrix[r2][c]);
                    }
                    
                    for (int r = r2; r > r1; r--) {
                        spiralList.add(matrix[r][c1]);
                    }
                }
                
                r1++;
                r2--;
                c1++;
                c2--;
            }
        }
        
        return spiralList;
    }
}