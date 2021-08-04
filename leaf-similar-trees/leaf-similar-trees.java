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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> first = new ArrayList<Integer>();
        List<Integer> second = new ArrayList<Integer>();
        getLeaves(root1, first);
        getLeaves(root2, second);
        if (first.size() != second.size()) {
            return false;
        }
        
        for (int i = 0; i < first.size(); i++) {
            if (first.get(i) != second.get(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private void getLeaves(TreeNode current, List<Integer> leaves) {
        if (current != null) {
            if (current.left == null && current.right == null) {
                leaves.add(current.val);
            }
            
            getLeaves(current.left, leaves);
            getLeaves(current.right, leaves);
        }
    }
}