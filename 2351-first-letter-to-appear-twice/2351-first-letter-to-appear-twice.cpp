class Solution {
public:
    char repeatedCharacter(string s) {
        int letterInventory[26] = {0};
        for (int i = 0; i < s.length(); i++) {
            if (letterInventory[s[i] - 97]) {
                return s[i];
            }
            
            letterInventory[s[i] - 97]++;
        }
        
        return ' ';
    }
};