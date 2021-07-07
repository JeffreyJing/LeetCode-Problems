/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    int maxDiameter = 0;
    public int diameter(Node root) {
        getDiameter(root);
        return maxDiameter;
    }
    
    private int getDiameter(Node current) {
        if (current == null) {
            return 0;
        }
        
        int maxHeight = 0;
        int secondMax = 0;
        for (Node child : current.children) {
            int currentHeight = getDiameter(child);
            if (currentHeight > maxHeight) {
                secondMax = maxHeight;
                maxHeight = currentHeight;
            } else if (currentHeight > secondMax) {
                secondMax = currentHeight;
            }
        }
            
        maxDiameter = Math.max(maxDiameter, maxHeight + secondMax);        
        return maxHeight + 1;
    }
}