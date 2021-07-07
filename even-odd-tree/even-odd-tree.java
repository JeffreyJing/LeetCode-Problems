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
    public boolean isEvenOddTree(TreeNode root) {
        Map<Integer, ArrayList<Integer>> levelToNodes = checkLevels(root, new HashMap<Integer, ArrayList<Integer>>(), 0);
        for (Integer level : levelToNodes.keySet()) {
            ArrayList<Integer> currentLevel = levelToNodes.get(level);
            printList(currentLevel);
            int previous = currentLevel.get(0);
            if (currentLevel.size() == 1) {
                if (level % 2 == previous % 2) {
                    return false;
                } 
            }
            
            for (int i = 1; i < currentLevel.size(); i++) {
                int currentValue = currentLevel.get(i);
                if (level % 2 == 0) {
                    if (previous >= currentValue || currentValue % 2 == 0) {
                        return false;
                    }
                } else {
                    if (previous <= currentValue || currentValue % 2 != 0) {
                        return false;
                    }
                }
                
                previous = currentValue;
            }
        }
        
        return true;
    }
    
    private HashMap<Integer, ArrayList<Integer>> checkLevels(TreeNode current, HashMap<Integer, ArrayList<Integer>> levelToNodes, int level) {
        if (current != null) {
            if (!levelToNodes.containsKey(level)) {
                levelToNodes.put(level, new ArrayList<Integer>());
            } 
            
            levelToNodes.get(level).add(current.val);
            checkLevels(current.left, levelToNodes, level + 1);
            checkLevels(current.right, levelToNodes, level + 1);
        }
        
        return levelToNodes;
    }
    
    private void printList(ArrayList<Integer> values) {
        for (Integer value : values) {
            System.out.print(value + " ");
        }
        
        System.out.println();
    }
}