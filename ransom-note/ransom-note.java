class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letterInventory = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char current = magazine.charAt(i);
            letterInventory[current - 97]++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            char current = ransomNote.charAt(i);
            letterInventory[current - 97]--;
        }
        
        for (int i = 0; i < letterInventory.length; i++) {
            if (letterInventory[i] < 0) {
                return false;
            }
        }
        
        return true;
    }
}