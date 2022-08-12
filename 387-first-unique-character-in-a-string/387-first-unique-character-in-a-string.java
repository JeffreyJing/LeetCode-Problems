class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charToCount.containsKey(c)) {
                charToCount.put(c, 1); 
            } else {
                charToCount.put(c, charToCount.get(c) + 1);
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (charToCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        return -1;
    }
}