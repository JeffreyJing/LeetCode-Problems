class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            result.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (result.containsKey(complement) && result.get(complement) != i) {
                return new int[] { i, result.get(complement) };
            }
        }
        
        return null;
    }
}