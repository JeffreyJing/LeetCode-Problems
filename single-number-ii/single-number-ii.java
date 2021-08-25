class Solution {
    public int singleNumber(int[] nums) {
        long sum = 0;
        Set<Long> values = new HashSet<Long>();
        for (int num : nums) {
            sum += num;
            values.add((long) num);
        }
        
        long setSum = 0;
        for (Long value : values) {
            setSum += value;
        }
        
        return (int) ((3 * setSum - sum) / 2);
    }
}