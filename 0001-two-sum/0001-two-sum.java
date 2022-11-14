class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffToIndex = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            diffToIndex.put(target - nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (diffToIndex.containsKey(nums[i])) {
                int current = diffToIndex.get(nums[i]);
                if (current != i) {
                    result[0] = i;
                    result[1] = current;
                }
            }
        }
        
        return result;
    }
}