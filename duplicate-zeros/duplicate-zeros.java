class Solution {
    public void duplicateZeros(int[] list) {
        List<Integer> storage = new ArrayList<Integer>();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 0) {
                storage.add(list[i]);
            }
            
            storage.add(list[i]);
        }
        
        for (int i = 0; i < list.length; i++) {
            list[i] = storage.get(i);
        }
    }
}
