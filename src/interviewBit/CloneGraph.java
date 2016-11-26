package interviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//class UndirectedGraphNode {
//     int label;
//     List<UndirectedGraphNode> neighbors;
//     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
//};

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

Nodes are labeled uniquely.

 * @author mrincodi
 * 2016-08-15
 * Comment: This works even with repeated nodes.
 */
public class CloneGraph {


	/**
	 * Definition for undirected graph.
	 * class UndirectedGraphNode {
	 *     int label;
	 *     List<UndirectedGraphNode> neighbors;
	 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	 * };
	 */
	HashMap <UndirectedGraphNode, UndirectedGraphNode> createdNodes = new HashMap <UndirectedGraphNode, UndirectedGraphNode> ();

	public synchronized UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null ) return null;

		if (createdNodes.containsKey(node)) return createdNodes.get(node);

		UndirectedGraphNode clonedNode = new UndirectedGraphNode (node.label);
		createdNodes.put (node, clonedNode);

		for ( int i = 0; i < node.neighbors.size();i++){
			UndirectedGraphNode aNeighbor = cloneGraph (node.neighbors.get(i));
			clonedNode.neighbors.add(aNeighbor);
		}
		return clonedNode;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
