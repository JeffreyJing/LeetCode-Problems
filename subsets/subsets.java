class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
        int max = 1 << nums.length;
        for (int i = 0; i < max; i++) {
            List<Integer> subset = new ArrayList<Integer>();
            for (int j = 0, b = i; j < nums.length; j++, b >>= 1) {
                if ((b & 1) != 0) {
                    subset.add(nums[j]);
                }
            }
            
            powerSet.add(subset);
        }
        
        return powerSet;
    }
}