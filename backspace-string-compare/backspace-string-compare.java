class Solution {
    public boolean backspaceCompare(String first, String second) {
        int firstIndex = first.length() - 1;
        int secondIndex = second.length() - 1;
        int firstSkips = 0;
        int secondSkips = 0;
        while (firstIndex >= 0 || secondIndex >= 0) {
            while (firstIndex >= 0) {
                if (first.charAt(firstIndex) == '#') {
                    firstSkips++;
                    firstIndex--;
                } else if (firstSkips > 0) {
                    firstSkips--;
                    firstIndex--;
                } else {
                    break;
                }
            }
            
            while (secondIndex >= 0) {
                if (second.charAt(secondIndex) == '#') {
                    secondSkips++;
                    secondIndex--;
                } else if (secondSkips > 0) {
                    secondSkips--;
                    secondIndex--;
                } else {
                    break;
                }
            }
            
            if (firstIndex >= 0 && secondIndex >= 0 && first.charAt(firstIndex) != second.charAt(secondIndex)) {
                return false;
            }
            
            if ((firstIndex >= 0) != (secondIndex >= 0)) {
                return false;
            }
            
            firstIndex--;
            secondIndex--;
        }
        return true;
    }
    
    /* public boolean backspaceCompare(String first, String second) {
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
    */
}