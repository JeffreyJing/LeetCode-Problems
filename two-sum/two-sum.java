class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }
        
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numToIndex.containsKey(diff) && numToIndex.get(diff) != i) {
                answer[0] = i;
                answer[1] = numToIndex.get(diff);
            }
        }
        
        return answer;
    }
}