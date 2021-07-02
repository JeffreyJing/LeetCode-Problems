class Solution {
    public int mySqrt(int x) {
        for (int i = 0; i <= x; i++) {
            if ((i * i <= x) && ((i + 1) * (i + 1) > x) || ((i + 1) * (i + 1) < 0)) {
                return i;
            }
        }
        
        return x;
    }
}