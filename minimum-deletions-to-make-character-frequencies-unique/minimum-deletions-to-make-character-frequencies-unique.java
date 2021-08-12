class Solution {
    public int minDeletions(String s) {
        int[] letterInventory = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterInventory[s.charAt(i) - 97]++;
        }
        
        int count = 0;
        Set<Integer> frequencies = new HashSet<Integer>();
        for (int i = 0; i < 26; i++) {
            int frequency = letterInventory[i];
            if (frequency != 0) {
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
        }
        
        return count;
    }
}