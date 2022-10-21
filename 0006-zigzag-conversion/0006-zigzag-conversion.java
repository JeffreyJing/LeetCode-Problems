class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        List<StringBuilder>rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        
        int row = 0;
        boolean goingDown = false;
        for (char c: s.toCharArray()) {
            rows.get(row).append(c);
            if (row == 0 || row == numRows - 1) goingDown = !goingDown;
            row += goingDown ? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder currentRow : rows) { 
            result.append(currentRow);
        }
        
        return result.toString();
    }
}