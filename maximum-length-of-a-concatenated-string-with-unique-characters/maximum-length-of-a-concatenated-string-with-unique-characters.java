class Solution {
    
    private int max;
    public int maxLength(List<String> sequences) {
        this.max = 0;
        findMax(sequences, "", 0);
        return this.max;
    }
    
    private void findMax(List<String> sequences, String result, int index) {
        if (index != sequences.size()) {
            String currentSequence = result + sequences.get(index);
            if (allUnique(currentSequence)) {
                findMax(sequences, currentSequence, index + 1);
            } 
            
            findMax(sequences, result, index + 1);
        }
        
        this.max = Math.max(max, result.length());
    }
    
    private boolean allUnique(String sequence) {
        Set<Character> characters = new HashSet<Character>();
        for (int i = 0; i < sequence.length(); i++) {
            char currentChar = sequence.charAt(i);
            if (!characters.contains(currentChar)) {
                characters.add(currentChar);
            } else {
                return false;
            }
        }
        
        return true;
    }
}