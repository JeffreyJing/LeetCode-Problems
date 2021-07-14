class Solution {
    
    private int max;
    public int maxLength(List<String> sequences) {
        this.max = 0;
        findMax(sequences, new HashSet<String>(), "", 0);
        return this.max;
    }
    
    private void findMax(List<String> sequences, HashSet<String> invalids, String result, int index) {
        if (index != sequences.size()) {
            String currentSequence = sequences.get(index);
            if (!invalids.contains(result + currentSequence)) {
                if (allUnique(result + currentSequence)) {
                    findMax(sequences, invalids, result + currentSequence, index + 1);
                } else {
                    invalids.add(result + currentSequence);
                }
            }
            
            findMax(sequences, invalids, result, index + 1);
        }
        
        max = Math.max(max, result.length());
    }
    
     private boolean allUnique(String sequence) {
        Set<Character> characters = new HashSet<Character>();
        for (int i = 0; i < sequence.length(); i++) {
            char letter = sequence.charAt(i);
            if (characters.contains(letter)) {
                return false;
            }
            
            characters.add(letter); 
        }
        
        return true;
    } 
    
    /* solution for pair of strings
    public int maxLength(List<String> sequences) {
        List<String> sequencesCopy = new ArrayList<String>();
        for (int i = 0; i < sequences.size(); i++) {
            sequencesCopy.add(sequences.get(i));    
        }
        
        int size = sequencesCopy.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                sequencesCopy.add(sequencesCopy.get(i) + sequencesCopy.get(j));
            }
        }
        
        int largestUnique = 0;
        for (int i = 0; i < sequencesCopy.size(); i++) {
            String currentSequence = sequencesCopy.get(i);
            int currentSize = currentSequence.length();
            if (allUnique(currentSequence) && currentSize > largestUnique) {
                largestUnique = currentSize;
            }
        }
        
        return largestUnique;
    } 
    */
}