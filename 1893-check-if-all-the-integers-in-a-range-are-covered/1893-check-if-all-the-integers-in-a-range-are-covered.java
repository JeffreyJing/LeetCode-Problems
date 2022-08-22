class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int numRanges = ranges.length;
        for (int i = left; i <= right; i++) {
            int numOut = 0;
            for (int j = 0; j < ranges.length; j++) {
                if (i < ranges[j][0] || i > ranges[j][1]) {
                    numOut++;
                } 
            }
            
            if (numOut == numRanges) {
                return false;
            }
        }
        
        return true;
    }
}