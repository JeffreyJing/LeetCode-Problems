class Solution {
    public int numIdenticalPairs(int[] nums) {
        int pairs = 0;
        Map<Integer, Integer> storage = new HashMap<Integer, Integer>();
        for (int number : nums) {
            if (storage.containsKey(number)) {
                pairs += storage.get(number);
                storage.put(number, storage.get(number) + 1);
            } else {
                storage.put(number, 1);
            }
        }
        
        return pairs;
    }
}