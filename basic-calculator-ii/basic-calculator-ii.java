class Solution {
    public int calculate(String str) {
        Stack<Integer> stack = new Stack<Integer>();
        int length = str.length();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = str.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                
                operation = currentChar;
                currentNumber = 0;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
}