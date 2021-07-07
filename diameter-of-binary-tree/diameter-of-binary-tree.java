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
    
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return diameter;
    }
    
    private int getDiameter(TreeNode current) {
        if (current == null) {
            return 0;
        }
    
        int leftHeight = getDiameter(current.left);
        int rightHeight = getDiameter(current.right);
        int currentMax = Math.max(leftHeight, rightHeight);
        
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return currentMax + 1;
    }
}