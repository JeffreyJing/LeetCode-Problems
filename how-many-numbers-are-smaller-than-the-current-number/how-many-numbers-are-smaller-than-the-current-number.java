class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numberInventory = new int[101];
        int[] answers = new int[nums.length];
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            numberInventory[nums[i]]++;
        }
        
        int index = 0;
        int count = 0;
        int temp  = 0;
        while (index < 101 && count < length) {
            if (numberInventory[index] != 0) {
                temp = numberInventory[index];
                numberInventory[index] = count;
                count += temp;
            }
            
            index++;
        }
        
        for (int i = 0; i < length; i++) {
            answers[i] = numberInventory[nums[i]];
        }
        
        return answers;
    }
}