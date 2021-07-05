class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        int min = 0;
        int max = numbers.length - 1;
        while (min < max) {
            if (numbers[min] + numbers[max] == target) {
                indices[0] = min + 1;
                indices[1] = max + 1;
                return indices;
            }
            
            if (numbers[min] + numbers[max] < target) {
                min++;
            } else {
                max--;
            }
        }
        
        return indices;
    }
}