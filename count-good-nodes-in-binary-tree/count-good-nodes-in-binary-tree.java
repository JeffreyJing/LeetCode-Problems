/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }
    
    private int goodNodes(TreeNode current, int largest) {
        if (current != null) {
            int currentValue = 0;
            if (current.val >= largest) {
                currentValue = 1;
                largest = current.val;
            }
            
            return currentValue + goodNodes(current.left, largest) + goodNodes(current.right, largest);
        }
        
        return 0;
    }
}