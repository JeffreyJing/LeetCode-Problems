class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(i - indexDiff, 0); j < i; j++) {
                if (Math.abs((long) nums[i] - nums[j]) <= valueDiff) {
                    return true;
                }
            }
        }
        
        return false;
    }
}