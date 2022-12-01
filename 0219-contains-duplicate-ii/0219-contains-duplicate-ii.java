class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> valToIndex = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (!valToIndex.containsKey(nums[i])) {
                valToIndex.put(nums[i], new ArrayList<Integer>());
                valToIndex.get(nums[i]).add(i);
            } else {
                List<Integer> indices = valToIndex.get(nums[i]);
                for (int j = 0; j < indices.size(); j++) {
                    if (Math.abs(i - indices.get(j)) <= k) {
                        return true;
                    }
                }
                
                indices.add(i);
            }
        }
        
        return false;
    }
}