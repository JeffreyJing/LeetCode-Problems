class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int first = num1.length() - 1;
        int second = num2.length() - 1;
        while (first >= 0 || second >= 0) {
            int x1 = first >= 0 ? num1.charAt(first) - '0' : 0;
            int x2 = second >= 0 ? num2.charAt(second) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            result.insert(0, value);
            first--;
            second--;
        }
        
        if (carry != 0) {
            result.insert(0, carry);
        }
        
        return result.toString();
    }
}