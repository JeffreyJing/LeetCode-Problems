/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
​
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Stack<TreeNode> storage = new Stack<TreeNode>();
        storage.push(root.left);
        storage.push(root.right);
        while (!storage.isEmpty()) {
            TreeNode first = storage.pop();
            TreeNode second = storage.pop();
            if (!(first == null && second == null)) {
                if (first == null || second == null) {
                    return false;
                }
                
                if (first.val != second.val) {
                    return false;
                }
                
                storage.push(first.left);
                storage.push(second.right);
                storage.push(first.right);
                storage.push(second.left);
            }
        }
        
        return true;
    }
}
