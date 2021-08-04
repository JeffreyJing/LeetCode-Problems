class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = 0;
        while (row + 1 < matrix.length && target >= matrix[row + 1][0]) {
            row++;
        }
                
        if (row >= matrix.length) {
            return false;
        }
                
        return binarySearch(matrix[row], target, 0, matrix[row].length - 1);
    }
    
    private boolean binarySearch(int[] list, int target, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;            
            if (target == list[mid]) {
                return true;
            }
            
            if (target < list[mid]) {
                return binarySearch(list, target, start, mid - 1);
            }
            
            if (target > list[mid]) {
                return binarySearch(list, target, mid + 1, end);
            }
        }
        
        return false;
    }
}