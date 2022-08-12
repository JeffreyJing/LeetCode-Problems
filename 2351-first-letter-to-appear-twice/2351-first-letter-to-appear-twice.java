class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> characters = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characters.contains(c)) {
                return c;
            }
            
            characters.add(c);
        }
        
        return ' ';
    }
}