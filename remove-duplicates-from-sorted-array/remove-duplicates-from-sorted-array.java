class Solution {
    public int removeDuplicates(int[] list) {
        if (list.length == 0) {
            return 0;
        }
        
        int index = 0;
        int current = list[0];
        int finalLength = 1;
        for (int i = 0; i < list.length; i++) {
            while (i < list.length && list[i] == current) {
                i++;
            }
            
            if (i < list.length && list[i] != current) {
                list[index + 1] = list[i];
                index++;
                finalLength++;
                current = list[i];
            }
        }
        
        return finalLength;
    }
}
