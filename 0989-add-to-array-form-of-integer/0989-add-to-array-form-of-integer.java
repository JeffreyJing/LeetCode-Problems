class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int current = k;
        List<Integer> result = new ArrayList<Integer>();
        int index = num.length - 1;
        while (index >= 0 || current > 0) {
            if (index >= 0) {
                current += num[index];
            }
            
            result.add(0, current % 10);
            current /= 10;
            index--;
        }
        
        return result;
    }
}