class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = 0;
        int start = 0;
        while (start < nums.length && nums[start] != 1) {
            start++;
        }
        
        for (int i = start; i< nums.length; i++) {
            if (nums[i] == 1) {
                System.out.println("count = " + count);
                if (count < k && i != start) {
                    return false;
                }
                
                count = -1;
            } 
            
            count++;
        }
        
        return true;
    }
}