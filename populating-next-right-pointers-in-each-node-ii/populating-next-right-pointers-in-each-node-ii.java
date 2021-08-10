/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Map<Integer, List<Node>> levelToNodes = new HashMap<Integer, List<Node>>();
        connect(root, levelToNodes, 0);
        for (Integer level : levelToNodes.keySet()) {
            List<Node> currentNodes = levelToNodes.get(level);
            if (currentNodes.size() == 1) {
                currentNodes.get(0).next = null;
            } else {
                for (int i = 0; i < currentNodes.size() - 1; i++) {
                    currentNodes.get(i).next = currentNodes.get(i + 1);
                }
                
                currentNodes.get(currentNodes.size() - 1).next = null;
            }
        }
        
        return root;
    }
    
    private void connect(Node current, Map<Integer, List<Node>> levelToNodes, int level) {
        if (current != null) {
            if (!levelToNodes.containsKey(level)) {
                levelToNodes.put(level, new ArrayList<Node>());
            }
            
            levelToNodes.get(level).add(current);
            connect(current.left, levelToNodes, level + 1);
            connect(current.right, levelToNodes, level + 1);
        }
    }
}