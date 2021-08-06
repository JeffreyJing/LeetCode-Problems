class Solution {
    public boolean backspaceCompare(String first, String second) {
        return backspace(first).equals(backspace(second));
    }
    
    private String backspace(String letters) {
        for (int i = 0; i < letters.length(); i++) {
            if (letters.charAt(i) == '#') {
                if (i > 0) {
                    letters = letters.substring(0, i - 1) + letters.substring(i + 1);
                    i -=2;
                } else {
                    letters = letters.substring(1);
                    i--;
                }
            }
        }
        
        return letters;
    }
}