class Solution {
    public String makeGood(String s) {
        Stack<Character> storage = new Stack<Character>();
        storage.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!storage.isEmpty() && Math.abs(storage.peek() - s.charAt(i)) == 32) {
                storage.pop();
            } else {
                storage.add(s.charAt(i));
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char currentChar : storage) {
            result.append(currentChar);
        }
        
        return result.toString();
    }
}