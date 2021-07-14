class Solution {
    
    private Map<Integer, List<String>> pairsToParens = new HashMap<Integer, List<String>>();
    private int max = 0;
    public List<String> generateParenthesis(int pairs) {
        if (!pairsToParens.containsKey(pairs)) {
            if (max == 0) {
                List<String> parens = new ArrayList<String>();
                parens.add("()");
                pairsToParens.put(1, parens);
                max++;
            }
            
            while (max <= pairs) {
                List<String> parens = pairsToParens.get(max);
                Set<String> uniqueParens = new HashSet<String>();
                List<String> newList = new ArrayList<String>();
                for (int i = 0; i < parens.size(); i++) {
                    String currentParens = parens.get(i);
                    for (int j = 0; j < currentParens.length(); j++) {
                        String newParens = currentParens.substring(0, j + 1) + "()" + currentParens.substring(j + 1);
                        if (!uniqueParens.contains(newParens)) {
                            uniqueParens.add(newParens);
                            newList.add(newParens);
                        }
                    }
                }
                
                max++;
                pairsToParens.put(max, newList);
            }
        }
        
        return pairsToParens.get(pairs);
    }
}