class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(target, new LinkedList<Integer>(), 0, candidates, result);
        return result;
    }
    
    private void backtrack(int remain, LinkedList<Integer> comb, int start, int[] candidates, List<List<Integer>> result) {
        if (remain >= 0) {
            if (remain == 0) {
                result.add(new ArrayList<Integer>(comb));
            } else {
                for (int i = start; i < candidates.length; i++) {
                    int current = candidates[i];
                    if (remain >= current) {
                        comb.add(current);
                        backtrack(remain - current, comb, i, candidates, result);
                        comb.removeLast();
                    }
                }
            }
        }  
    }
    
}