class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int number = nums[i];
            current = Math.max(number, current + number);
            max = Math.max(max, current);
        }
        
        return max;
    }
}