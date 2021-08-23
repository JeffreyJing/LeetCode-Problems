class Solution {
    public String longestPalindrome(String s) {
        if (s != null && s.length() > 0) {
            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandCenter(s, i, i);
                int len2 = expandCenter(s, i , i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            
            return s.substring(start, end + 1);
        }
        
        return "";
    }
    
    private int expandCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        
        return R - L - 1;
    }
}