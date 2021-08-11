class Solution {
    
    private int index;
    public String reverseWords(String s) {
        Stack<String> wordStack = new Stack<String>();
        this.index = 0;
        int length = s.length();
        while (index < length) {
            wordStack.push(getNextWord(s));
        }
        
        String reversedWords = "";
        while (!wordStack.isEmpty()) {
            String word = wordStack.pop();
            if (word != "") {
                reversedWords += word;
                if (!wordStack.isEmpty()) {
                    reversedWords += " ";
                } 
            }
        }
        
        return reversedWords;
    }
    
    private String getNextWord(String s) {
        if (index < s.length()) {
            while(index < s.length () && s.charAt(index) == ' ') {
                index++;
            }
            
            String word = "";
            while (index < s.length() && s.charAt(index) != ' ') {
                word += s.charAt(index);
                index++;
            }
            
            return word;
        }
        
        return "";
    }
}