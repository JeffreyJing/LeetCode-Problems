/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        return isAnagram(total(root1), (total(root2)));
    }
    
    private String total(Node current) {
        if (current != null) {
            if (current.val == '+') {
                return total(current.left) + total(current.right);
            }
            
            return "" + current.val; 
        }
        
        return "";
    }
    
    private boolean isAnagram(String first, String second) {
        char[] letterInventory = new char[26];
        for (int i = 0; i < first.length(); i++) {
            letterInventory[first.charAt(i) - 97]++;
        }
        
        for (int i = 0; i < second.length(); i++) {
            letterInventory[second.charAt(i) - 97]--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (letterInventory[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}