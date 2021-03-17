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
    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private int maxDiff(TreeNode current, int max, int min) {
        if (current != null) {
            if (max < current.val) {
                max = current.val;
            }
            
            if (min > current.val) {
                min = current.val;
            }
            
            if (current.left == null && current.right == null) {
                return max - min; 
            } else {
                return Math.max(maxDiff(current.left, max, min), maxDiff(current.right, max, min));
            }
        }
        
        return 0;
    }
}
