class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(result, new LinkedList<Integer>(), 0, k, n);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, LinkedList<Integer> currentList, int start, int size, int total) {
        if (total == 0 && currentList.size() == size) {
            result.add(new ArrayList<Integer>(currentList));
            return;
        } else if (total < 0 || currentList.size() == size) {
            return;
        }
            
        for (int i = start; i < 9; i++) {
            currentList.add(i + 1);
            backtrack(result, currentList, i + 1, size, total - i - 1);
            currentList.removeLast();
        }
        
    }
}