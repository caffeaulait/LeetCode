package com.caffeaulait;
import java.util.*;

public class _0133_CloneGraph {
    /**
     *Given a reference of a node in a connected undirected graph.
     *
     * Return a deep copy (clone) of the graph.
     *
     * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
     */

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


    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return clone(node, map);
    }

    private Node clone(Node node, Map<Integer, Node> map){
        if (node == null) return null;
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }else{
            Node cloneNode = new Node(node.val);
            map.put(node.val, cloneNode);
            for (int i = 0; i < node.neighbors.size();i++){
                cloneNode.neighbors.add(clone(node.neighbors.get(i), map));
            }
            return cloneNode;
        }
    }
}
