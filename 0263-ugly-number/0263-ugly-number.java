class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        n = keepDividingBy(2, n);
        n = keepDividingBy(3, n);
        n = keepDividingBy(5, n);
        return n == 1;
    }
    
    private int keepDividingBy(int divisor, int dividend) {
        while(dividend % divisor == 0) {
            dividend /= divisor;
        } 
        
        return dividend;
    }
}