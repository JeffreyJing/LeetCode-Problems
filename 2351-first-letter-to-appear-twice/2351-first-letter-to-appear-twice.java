class Solution {
    public char repeatedCharacter(String s) {
        int[] letterInventory = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (letterInventory[current - 97] > 0) {
                return current;
            }
            
            letterInventory[current - 97]++;
        }
        
        return ' ';
    }
}