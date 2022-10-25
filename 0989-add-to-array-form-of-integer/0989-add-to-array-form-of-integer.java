class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int size = num.length;
        int current = k;
        List<Integer> result = new ArrayList<Integer>();
        int i = size;
        while (--i >= 0 || current > 0) {
            if (i >= 0) {
                current += num[i];
            }
            
            result.add(0, current % 10);
            current /= 10;
        }
        
        return result;
    }
}