// Given a reference of a node in a connected
// undirected graph.
// Return a deep copy (clone) of the graph.
// Each node in the graph contains a value 
// (int) and a list (List[Node]) of its neighbors.
// class Node {
//     public int val;
//     public List<Node> neighbors;
// }
// Test case format:
// For simplicity, each node's value is the
// same as the node's index (1-indexed). For
// example, the first node with val == 1,
// the second node with val == 2, and so on.
// The graph is represented in the test case
// using an adjacency list.

// An adjacency list is a collection of
// unordered lists used to represent a
// finite graph. Each list describes the
// set of neighbors of a node in the graph.

// The given node will always be the first
// node with val = 1. You must return the
// copy of the given node as a reference to
// the cloned graph.
// The number of nodes in the graph is in
// the range [0, 100].
// 1 <= Node.val <= 100
// Node.val is unique for each node.
// There are no repeated edges and no self-loops
// in the graph.
// The Graph is connected and all nodes can be
// visited starting from the given node.
/*
// Definition for a Node.
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
public Node cloneGraph(Node node) {
// O(1) time, O(1) space
    if(node == null){
        return null;
    }
// O(1) time, O(1) space
    Node newNode = new Node(node.val);
// O(1) time, O(V) space: store a copy for each node
    Map<Node, Node> map = new HashMap<>();
    map.put(node, newNode);
// O(1) time, O(V) space: BFS queue may hold up to all nodes
    Queue<Node> que = new LinkedList<>();
    que.add(node);
    // O(V) time: loop runs once per node in graph
    while(!que.isEmpty()){
        // O(1) per node
        Node polledNode = que.poll();
// O(E) total: sum over all neighbors (all edges)
        for(var neighbor : polledNode.neighbors){
// O(1) per node, contributes to O(V) total
            if(!map.containsKey(neighbor)){  
// O(1) per node
               Node newNeighbor = new Node(neighbor.val);
// O(1) per node, part of O(V) space
               map.put(neighbor, newNeighbor);
// O(1) per node, contributes to O(V) total
               que.add(neighbor);              
            }
// O(1) per edge, total O(E)
            map.get(polledNode).neighbors.add(map.get(neighbor)); 
        }
    }
// O(1) time, return output
    return newNode;
}

// Time : O(V + E) → nodes + edges
// Space : O(V) → map + queue