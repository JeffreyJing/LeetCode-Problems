class Solution {
    public String removeVowels(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (!isVowel(str.charAt(i))) {
                newStr += str.charAt(i);
            }
        }
        
        return newStr;
    }
    
    private boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' ||
               letter == 'o' || letter == 'u';
    }
}
