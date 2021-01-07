class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int count = 1, max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        
        return max;
    }
}
