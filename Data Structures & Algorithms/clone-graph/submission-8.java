/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node head = new Node();
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Node> alrVisited = new HashMap<>();
        recurse(node, head, seen, alrVisited);

        return head;

    }
    public void recurse(Node n, Node copy, Set<Integer> seen, Map<Integer, Node> visited) {
        copy.val = n.val;
        List<Node> copyNs = new ArrayList<>();
        seen.add(n.val);
        visited.put(n.val, copy);
        for (Node neighbor : n.neighbors) {
            Node copyN = new Node();
            if (!seen.contains(neighbor.val)) {
                copyN = new Node(neighbor.val);
                visited.put(neighbor.val, copyN);
                recurse(neighbor, copyN, seen, visited);
            }
            else {
                copyN = visited.get(neighbor.val);
            }
            copyNs.add(copyN);
        }
        copy.neighbors = copyNs;
    }
}