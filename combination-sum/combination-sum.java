class Solution {
    
    // use a LinkedList
    // sort the given array
    // use backtracking to fill the list of lists
    
    // backtracking: if the target is reached (== 0), add the current list
    // to the result.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(candidates, result, new LinkedList<Integer>(), target, 0);
        return result;
    }
    
    private void backtrack(int[] candidates, List<List<Integer>> result, LinkedList<Integer> currentList, int remaining, int start) {
        if (remaining == 0) {
            result.add(new ArrayList<Integer>(currentList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                int current = candidates[i];
                if (remaining >= current) {
                    currentList.add(current);
                    backtrack(candidates, result, currentList, remaining - current, i);
                    currentList.removeLast();
                }
            }
        }
    }
}