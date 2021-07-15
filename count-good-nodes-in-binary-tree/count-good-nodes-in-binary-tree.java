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
    
    private int goodNodes(TreeNode current, int currentGreatest) {
        if (current != null) {
            int currentCount = 0;
            if (current.val >= currentGreatest) {
                currentCount++;
                currentGreatest = current.val;
            }
            
            return currentCount + goodNodes(current.left, currentGreatest) + goodNodes(current.right, currentGreatest);
        }
        
        return 0;
    }
    
    /*
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }
    
    private int goodNodes(TreeNode current, int biggest) {
        if (current != null) {
            biggest = biggest < current.val ? current.val : biggest;
            return (current.val >= biggest ? 1 : 0) + goodNodes(current.left, biggest) + goodNodes(current.right, biggest);
        }
        
        return 0;
    }
    */
    
    /* public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        goodNodes(root, root.val, count);
        return count[0];
    }
    
    private void goodNodes(TreeNode current, int biggest, int[] count) {
        if (current != null) {
            if (current.val >= biggest) {
                count[0]++;
                biggest = current.val;
            }
            
            goodNodes(current.left, biggest, count);
            goodNodes(current.right, biggest, count);
        }
    } */
}