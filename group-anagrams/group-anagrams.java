class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strToAnagram = new HashMap<String, List<String>>();
        for (String str : strs) {
            String sortedStr = sortString(str);
            if (!strToAnagram.containsKey(sortedStr)) {
                strToAnagram.put(sortedStr, new ArrayList<String>());
            }
            
            strToAnagram.get(sortedStr).add(str);
        }
        
        List<List<String>> anagrams = new ArrayList<List<String>>();
        for (String str : strToAnagram.keySet()) {
            anagrams.add(strToAnagram.get(str));
        }
        
        return anagrams;
    }
    
    private String sortString(String str) {
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        String sortedStr = "";
        for (int i = 0; i < strArray.length; i++) {
            sortedStr += strArray[i];
        }
        
        return sortedStr;
    }
}