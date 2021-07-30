class Solution {
    public String restoreString(String s, int[] indices) {
        String unshuffled = "";
        char[] ordered = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            ordered[indices[i]] = s.charAt(i); 
        }
        
        for (int i = 0; i < ordered.length; i++) {
            unshuffled += ordered[i];
        }
        
        return unshuffled;
    }
}