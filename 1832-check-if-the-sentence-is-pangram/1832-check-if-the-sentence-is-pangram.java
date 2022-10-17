class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] letterInventory = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            letterInventory[sentence.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < letterInventory.length; i++) {
            if (letterInventory[i] == 0) {
                return false;
            }
        }
        
        return true;
    }
}