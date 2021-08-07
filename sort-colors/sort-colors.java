class Solution {
    public void sortColors(int[] nums) {
        int index = 0;
        int low = 0;
        int high = nums.length - 1;
        while (index <= high) {
            if (nums[index] == 0) {
                swap(nums, index, low);
                index++;
                low++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, high);
                high--;
            }
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}