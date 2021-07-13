class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> charToCount = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!charToCount.containsKey(currentChar)) {
                charToCount.put(currentChar, 1);
            } else {
                charToCount.put(currentChar, charToCount.get(currentChar) + 1);
            }
        }
        
        int count = 0;
        Set<Integer> frequencies = new HashSet<Integer>();
        for (Character letter : charToCount.keySet()) {
            int frequency = charToCount.get(letter);
            if (!frequencies.contains(frequency)) {
                frequencies.add(frequency);
            } else {
                while (frequencies.contains(frequency)) {
                    frequency--;
                    count++;
                } 
                
                if (frequency != 0) {
                    frequencies.add(frequency);
                }
            }
        }
        
        return count;
    }
}