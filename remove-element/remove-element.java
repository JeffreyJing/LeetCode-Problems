class Solution {
    public int removeElement(int[] list, int val) {
        int finalLength = list.length;
        for (int i = 0; i < finalLength; i++) {
            if (list[i] == val) {
                list[i--] = list[finalLength-- -1];
            }
        }
        
    return finalLength;
    }
}
