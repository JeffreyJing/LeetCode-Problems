class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        triangle.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> previous = triangle.get(i - 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(previous.get(j - 1) + previous.get(j));
            }
            
            row.add(1);
            triangle.add(row);
        }
        
        return triangle;
    }
}