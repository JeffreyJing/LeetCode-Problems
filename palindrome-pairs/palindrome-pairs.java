class Solution {
    class TrieNode {
        TrieNode[] children;
        int wordIndex;
        List<Integer> restIsPalindrome;
        public TrieNode() {
            this.restIsPalindrome = new ArrayList<Integer>();
            this.wordIndex = -1;
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    int n;
    List<List<Integer>> result;
    public List<List<Integer>> palindromePairs(String[] words) {
        this.n = words.length;
        this.root = new TrieNode();
        this.result = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            add(words[i], i);
        }
        
        for (int i = 0; i < n; i++) {
            search(words[i], i);
        }
        
        return result;
    }
    
    private void search(String word, int wordIndex) {
        char[] chs = word.toCharArray();
        TrieNode current = root;
        for (int i = 0; i < chs.length; i++) {
            int j = chs[i] - 'a';
            if (current.wordIndex != -1 && isPalindrome(chs, i, chs.length - 1)) {
                result.add(Arrays.asList(wordIndex, current.wordIndex));
            }
            
            if (current.children[j] == null) {
                return;
            }
            
            current = current.children[j];
        }
            
        if (current.wordIndex != -1 && current.wordIndex != wordIndex) {
            result.add(Arrays.asList(wordIndex, current.wordIndex));
        }
        
        for (int j : current.restIsPalindrome) {
            result.add(Arrays.asList(wordIndex, j));
        }
    }
    
    private void add(String word, int wordIndex) {
        char[] chs = word.toCharArray();
        TrieNode current = this.root;
        for (int i = chs.length - 1; i >= 0; i--) {
            int j = chs[i] - 'a';
            if (isPalindrome(chs, 0, i)) {
                current.restIsPalindrome.add(wordIndex);
            }
            
            if (current.children[j] == null) {
                current.children[j] = new TrieNode();
            }
            
            current = current.children[j];
        }
        
        current.wordIndex = wordIndex;
    }
    
    private boolean isPalindrome(char[] chs, int i, int j) {
        while (i < j) {
            if (chs[i] != chs[j]) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    /*
    List<List<Integer>> pairs;
    public List<List<Integer>> palindromePairs(String[] words) {
        this.pairs = new ArrayList<List<Integer>>();
        findPalindromes(words, 0);
        return this.pairs;
    }
    
    private void findPalindromes(String[] words, int index) {
        if (index < words.length) {
            for (int i = 0; i < words.length; i++) {
                if (i != index) {
                    if (isPalindrome(words[i] + words[index])) {
                        List<Integer> newPair = new ArrayList<Integer>();
                        newPair.add(i);
                        newPair.add(index);
                        this.pairs.add(newPair);
                    }
                }
            }
            
            findPalindromes(words, index + 1);
        }
    }
    
    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    */
}