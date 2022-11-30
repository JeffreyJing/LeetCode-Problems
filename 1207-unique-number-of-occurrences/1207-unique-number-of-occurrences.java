class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> numbers = new HashSet<Integer>();
        Map<Integer, Integer> valToCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (!valToCount.containsKey(current)) {
                valToCount.put(current, 1);
            } else {
                valToCount.put(current, valToCount.get(current) + 1);
            }
        }
        
        for (Integer value : valToCount.keySet()) {
            int count = valToCount.get(value);
            if (numbers.contains(count)) {
                return false;
            }
            
            numbers.add(count);
        }
        
        return true;
    }
}