/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        return levelOrder(root, new ArrayList<List<Integer>>(), 0);   
    }
    
    private List<List<Integer>> levelOrder(Node current, ArrayList<List<Integer>> list, int level) {
        if (current != null) {
            if (level >= list.size()) {
                list.add(new ArrayList<Integer>());
            }
            
            list.get(level).add(current.val);
            for (Node child : current.children) {
                levelOrder(child, list, level + 1);
            }            
        }
        
        return list;
    }
}