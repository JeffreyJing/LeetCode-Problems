class Solution {
    
    boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0; 
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum % k != 0) {
            return false;
        }
        
        Arrays.sort(nums);
        this.visited = new boolean[nums.length];
        int target = sum / k;
        for (int i = 0; i < k - 1; i++) {
            if (!singlePartition(nums, target, nums.length - 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean singlePartition(int[] nums, int target, int index) {
        if (target == 0) {
            return true;
        }
        
        if (index < 0) {
            return false;
        }
        
        for (int i = index; i >= 0; i--) {
            int currentTarget = target - nums[i];
            if (currentTarget >= 0 && !visited[i]) {
                visited[i] = true;
                if (singlePartition(nums, currentTarget, index - 1)) {
                    return true;
                }
                
                visited[i] = false;
            }
        }
        
        return false;
    }
}