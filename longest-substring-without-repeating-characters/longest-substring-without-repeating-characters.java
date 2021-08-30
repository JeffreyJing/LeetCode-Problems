class Solution {
    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        Set<Character> characters = new HashSet<Character>();
        int slow = 0;
        int fast = 0;
        int max = 0;
        while (fast < str.length()) {
            char current = str.charAt(fast);
            while (characters.contains(current)) {
                characters.remove(str.charAt(slow));
                slow++;
            }
            
            characters.add(current);
            max = Math.max(max, fast - slow + 1);
            fast++;
        }
        
        return max;
    }
}