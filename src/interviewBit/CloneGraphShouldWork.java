package interviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

Nodes are labeled uniquely.

 * @author mrincodi
 * 2016-08-15
 * Comment: This works according to the problem statement.
 * Unfortunately one of the test cases from InterviewBit contains a repeated node, so this
 * fails for that case.
 */
public class CloneGraphShouldWork {

	/**
	 * Definition for undirected graph.
	 * class UndirectedGraphNode {
	 *     int label;
	 *     List<UndirectedGraphNode> neighbors;
	 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	 * };
	 */
	HashMap <Integer, UndirectedGraphNode> createdNodes = new HashMap <Integer, UndirectedGraphNode> ();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null ) return null;

		if (createdNodes.containsKey(node.label)) return createdNodes.get(node.label);

		System.out.println ("Creating node " + node.label);
		UndirectedGraphNode clonedNode = new UndirectedGraphNode (node.label);
		createdNodes.put (node.label, clonedNode);

		for ( int i = 0; i < node.neighbors.size();i++){
			UndirectedGraphNode aNeighbor = cloneGraph (node.neighbors.get(i));
			clonedNode.neighbors.add(aNeighbor);

			// if ( createdNodes.containsKey( theLabel )){
			//     clonedNode.neighbors.add(createdNodes.get(theLabel));
			// }
			// else {
			//     UndirectedGraphNode newNode = cloneGraph (node.neighbors.get(i));
			//     clonedNode.neighbors.add(newNode);
			// }
		}
		return clonedNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
