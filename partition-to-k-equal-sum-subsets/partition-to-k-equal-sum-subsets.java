class Solution {
    private boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.visited = new boolean[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum % k != 0) {
            return false;
        }
        
        Arrays.sort(nums);
        for(int i = 0; i < k; i++) {
            if(!check(nums, sum / k, nums.length - 1)) {
                return false;
            }
        }
        
        return true;
            
    }
    
    private boolean check(int[] nums, int target, int index) {
        if (target == 0) {
            return true;
        }
        
        if (index < 0) {
            return false;
        }
        
        for (int i = index; i >= 0; i--) {
            if (target - nums[i] >= 0 && !visited[i]) {
                visited[i] = true;
                if (check(nums, target - nums[i], i - 1)) {
                    return true;
                }
                
                visited[i] = false;
            }
        }
        
        return false;
    }
    
}