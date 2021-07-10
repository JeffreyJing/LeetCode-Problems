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
    int count = 0;
    public int goodNodes(TreeNode root) {
        goodNodes(root, root.val);
        return count;
    }
    
    private void goodNodes(TreeNode current, int biggest) {
        if (current != null) {
            if (biggest <= current.val) {
                count++;
                biggest = current.val;
            }

            goodNodes(current.left, biggest);
            goodNodes(current.right, biggest);
        }
    }
}