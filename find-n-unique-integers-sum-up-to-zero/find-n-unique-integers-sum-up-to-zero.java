class Solution {
    public int[] sumZero(int length) {
        int[] uniqueIntegers = new int[length];
        if (length % 2 == 1) {
            uniqueIntegers[length / 2] = 0;
        }
        
        for (int i = 0; i < length / 2; i++) {
            uniqueIntegers[i] = -1 * (length / 2 - i);
            uniqueIntegers[length - i - 1] = length / 2 - i;
        }
        
        return uniqueIntegers;
    }
}