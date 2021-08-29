class Solution {
    // Bellman Ford approach
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev = new int[n];
        Arrays.fill(prev, (int)1e9);
        prev[src] = 0;
        boolean anyUpdate = false;
        for (int i = 1; i <= k + 1; ++i) {
            anyUpdate = false;
            int[] curr = new int[n];
            for (int j = 0; j < n; ++j)
                curr[j] = prev[j];
            
            for (int[] f: flights) {
                int u = f[0], v = f[1], w = f[2];
                if (prev[u] != (int)1e9 && prev[u] + w < curr[v]) {
                    curr[v] = prev[u] + w;
                    anyUpdate = true;
                }
            }
            
            if (!anyUpdate) break;
            
            prev = curr;
        }
        return prev[dst] != (int)1e9 ? prev[dst] : -1;
    }
}