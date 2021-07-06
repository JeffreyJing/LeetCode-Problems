class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() <= s2.length()) {
            int windowLength = s1.length();
            int index = 0;
            while (index + windowLength <= s2.length()) {
                if (isPermutation(s1, s2.substring(index, index + windowLength))) {
                    return true;
                }
                
                index++;
            }
        }
        
        return false;
    }
    
    private boolean isPermutation(String first, String second) {
        int[] letterInventory = new int[26];
        for (int i = 0; i < first.length(); i++) {
            letterInventory[first.charAt(i) - 97]++; 
        }
        
        for (int i = 0; i < second.length(); i++) {
            letterInventory[second.charAt(i) - 97]--;
        }
        
        for (int i = 0; i < letterInventory.length; i++) {
            if (letterInventory[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}