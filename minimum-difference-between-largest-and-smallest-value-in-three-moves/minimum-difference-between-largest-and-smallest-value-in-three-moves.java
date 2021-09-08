class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        return difference(nums, 0, nums.length - 1, 3);
    }
    
    private int difference(int[] nums, int left, int right, int count) {
        if (right - left + 1 == 0) {
            return 0;
        }
        
        if (count == 0) {
            return nums[right] - nums[left];
        }
        
        return Math.min(difference(nums, left + 1, right, count - 1),
                        difference(nums, left, right - 1, count - 1));
    }
}