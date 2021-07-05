class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int maxSum = 0;
        Map<Integer, Integer> indexToVal = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            indexToVal.put(i, nums[i]);
        }
        
        for (int index : indexToVal.keySet()) {
            int value = indexToVal.get(index);
            for (int i = 0; i < nums.length; i++) {
                int sum = value + nums[i];
                if (i != index && sum < k && sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        
        return maxSum == 0 ? -1 : maxSum;
    }
}