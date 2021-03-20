class Solution {
    public int findKthPositive(int[] list, int kth) {
        if (kth < list[0]) {
            return kth;
        }
        
        int prev = list[0];
        kth -= list[0] - 1; 
        for (int i = 1; i < list.length; i++) {
            if (kth + prev + 1 <= list[i]) {
                return prev + kth;
            }
                
            if (kth == 0 && list[i] - prev > 1) {
                return prev;
            }
            
            kth -= (list[i] - prev) - 1; 
            prev = list[i];
        }
        
        return kth + list[list.length - 1];
    }
}