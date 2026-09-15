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

        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        dfs(node, visited, adjList);

        Node[] allNodes = new Node[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            allNodes[i] = new Node(i + 1);
        }

        for (Node n : allNodes) {
            ArrayList<Node> neighbors = new ArrayList<>();
            ArrayList<Integer> nInts = adjList.get(n.val);

            for (Integer i : nInts) {
                neighbors.add(allNodes[i - 1]);
            }

            n.neighbors = neighbors;
        }

        return allNodes[0];

    }
    private void dfs(Node curr, HashSet<Integer> visited, 
    HashMap<Integer, ArrayList<Integer>> adjList) {
        if (visited.contains(curr.val)) return;
        
        visited.add(curr.val);
        ArrayList<Integer> currNeighbs = new ArrayList<>();
        for (Node n : curr.neighbors) {
            currNeighbs.add(n.val);
            dfs(n, visited, adjList); 
        }

        adjList.put(curr.val, currNeighbs);
    }
}