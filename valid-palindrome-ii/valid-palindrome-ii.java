class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, false);
    }
    
    private boolean validPalindrome(String word, int left, int right, boolean deleted) {
        while (left < right) {
            if (word.charAt(left) != (word.charAt(right))) {
                if (deleted) {
                    return false;
                }
                
                return validPalindrome(word, left + 1, right, true) || validPalindrome(word, left, right - 1, true); 
            }
                
            left++;
            right--;
        }    
                
        return true;
    }
    
    /* 
    // naive solution- o(n^2) solution
    public boolean validPalindrome(String string) {
        if (string.equals(reverse(string))) {
            return true;
        }
        
        for (int i = 0; i < string.length(); i++) {
            String substring = string.substring(0, i) + string.substring(i + 1);
            if (substring.equals(reverse(substring))) {
                return true;
            }
        }
        
        return false;
    }
    
    private String reverse(String string) {
        String reversed = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reversed += string.charAt(i);
        }
        
        return reversed;
    }
    */ 
}