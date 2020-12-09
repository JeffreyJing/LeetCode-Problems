/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> storage = traverseTree(root, new TreeSet<Integer>());
        if (storage.size() <= 1) {
            return -1;
        }
        
        Iterator<Integer> iterator = storage.iterator();
        int current = iterator.next();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (current != next) {
                return next;
            }
        }
        
        return -1;
    }
    
    private Set<Integer> traverseTree(TreeNode current, Set<Integer> storage) {
        if (current != null) {
            storage.add(current.val);
            traverseTree(current.left, storage);
            traverseTree(current.right, storage);
        }
        
        return storage;
    } 
}
