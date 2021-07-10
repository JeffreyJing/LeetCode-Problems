class Solution {
    public int fib(int n) {
        int[] list = new int[n + 3];
        list[1] = 1;
        list[2] = 1;
        for (int i = 3; i <= n; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }
        
        return list[n];
    }
}