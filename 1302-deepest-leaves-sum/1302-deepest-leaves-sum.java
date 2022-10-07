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
    public int deepestLeavesSum(TreeNode root) {
        List<Integer> sums =  new ArrayList<Integer>();
        levelSum(root, sums, 1);
        if (sums.size() == 0) {
            return 0;
        }
        
        return sums.get(sums.size() - 1);
    }
    
    private void levelSum(TreeNode current, List<Integer> sums, int level) {
        if (current != null) {
            if (sums.isEmpty()) {
                sums.add(current.val);
            } else {
                if (sums.size() < level) {
                    sums.add(current.val);
                } else {
                    sums.set(level - 1, sums.get(level - 1) + current.val);
                }
            }
            
            levelSum(current.left, sums, level + 1);
            levelSum(current.right, sums, level + 1);
        }
    }
}