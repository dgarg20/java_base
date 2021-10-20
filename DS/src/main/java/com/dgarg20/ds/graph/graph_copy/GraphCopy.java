package com.dgarg20.ds.graph.graph_copy;

import java.util.*;

/**
 * Created by Deepanshu Garg on 30/05/21.
 */
public class GraphCopy {
    public Node cloneGraph(Node node) {
        if(node!=null){
            Node newGraph = new Node(node.val);
            HashMap<Integer, Node> newGraphElements = new HashMap<Integer, Node>();
            Node newGraphStart = newGraph;
            newGraphElements.put(node.val, newGraph);
            Set<Integer> oldGraphTraversed = new HashSet<Integer>();
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(node);
            while(!queue.isEmpty()) {
                Node temp = queue.poll();
                if(!oldGraphTraversed.contains(temp.val))
                    oldGraphTraversed.add(temp.val);
                else
                    continue;
                if(!temp.neighbors.isEmpty()){
                    for (Node tNode : temp.neighbors) {
                        queue.add(tNode);
                        if (newGraphElements.containsKey(tNode.val)) {
                            newGraphElements.get(temp.val).neighbors.add(newGraphElements.get(tNode.val));
                        } else {
                            Node newNode = new Node(tNode.val);
                            newGraphElements.put(newNode.val, newNode);
                            newGraphElements.get(temp.val).neighbors.add(newNode);
                        }
                    }
                }
            }
            return newGraph;
        }
        else return null;
    }
}



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

