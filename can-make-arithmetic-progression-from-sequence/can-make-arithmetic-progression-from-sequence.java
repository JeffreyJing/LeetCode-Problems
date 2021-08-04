class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int difference = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            int currentDiff = arr[i] - arr[i - 1];
            if (difference != currentDiff) {
                return false;
            }
        }
        
        return true;
    }
}