class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] letterInventory = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterInventory[s.charAt(i) - 97]++;
        }
        
        boolean seenOdd = false;
        for (int i = 0; i < 26; i++) {
            if (letterInventory[i] % 2 != 0) {
                if (!seenOdd) {
                    seenOdd = true;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}