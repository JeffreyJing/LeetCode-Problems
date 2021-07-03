class Solution {
    public String multiply(String first, String second) {
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        char[] result = new char[firstArray.length + secondArray.length];
        Arrays.fill(result, '0');
        for (int j = secondArray.length - 1; j >= 0; j--) {
            for (int i = firstArray.length - 1; i >= 0; i--) {
                int product = (firstArray[i] - '0') * (secondArray[j] - '0');
                int carryOver = result[i + j + 1] - '0' + product;
                result[i + j + 1] = (char) (carryOver % 10 + '0');
                result[i + j] = (char) ((result[i + j] - '0' + carryOver / 10) + '0');
            }
        }
        
        StringBuilder builder = new StringBuilder();
        boolean seen = false;
        for (char number : result) {
            if (number == '0' && !seen) {
                continue;
            }
            
            builder.append(number);
            seen = true;
        }
        
        return builder.length() == 0 ? "0" : builder.toString();
    }
}