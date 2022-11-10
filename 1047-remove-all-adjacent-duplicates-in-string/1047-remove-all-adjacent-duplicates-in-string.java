class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> storage = new Stack<Character>();
        storage.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!storage.isEmpty() && s.charAt(i) == storage.peek()) {
                storage.pop();
            } else {
                storage.push(s.charAt(i));
            }
        }
        
        StringBuilder result = new StringBuilder();
        while(!storage.isEmpty()) {
            result.insert(0, storage.pop());
        }
        
        return result.toString();
    }
}