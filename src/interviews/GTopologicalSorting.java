package interviews;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Stack;

/**
 * 
 *
 * @author mrincodi
 * 2016-11-15
 * Comment: If you don't know this, you may not get a job at...
 *
 */
class GraphNode {
	int val;
	LinkedHashSet <GraphNode> neighbors;

	GraphNode (int val){
		this.val=val;
		neighbors = new LinkedHashSet <GraphNode>();
	}
}
class DirectedGraph {

	static DirectedGraph dg = new DirectedGraph();

	int numVertices = 0;

	LinkedHashSet < GraphNode > nodes = new LinkedHashSet < GraphNode >();
	LinkedHashMap <Integer, GraphNode> valsToNodes = new LinkedHashMap <Integer, GraphNode> ();

	private DirectedGraph (){}

	public static DirectedGraph getInstance (){
		return dg;
	}

	void addNode (int val){
		if (!valsToNodes.containsKey(val)){
			GraphNode node = new GraphNode (val);
			nodes.add(node);
			valsToNodes.put(val, node);
		}
	}
	void addLink (int x, int y){
		GraphNode nodeX = valsToNodes.get(x);	//This will throw an  exception is node is not there.
		GraphNode nodeY = valsToNodes.get(y);
		nodeX.neighbors.add(nodeY);
	}

	public ArrayList <GraphNode> topologicalSorting () throws Exception{
		LinkedHashSet <GraphNode > recorded = new LinkedHashSet <GraphNode > ();

		ArrayList <GraphNode> result = new ArrayList <GraphNode> ();

		Stack <GraphNode> s = new Stack <GraphNode> ();
		for ( GraphNode node: nodes){
			LinkedHashSet <GraphNode > cycleChecker = new LinkedHashSet <GraphNode > ();
			topologicalSorting(node,s,recorded,cycleChecker);
		}
		
		while (!s.isEmpty()){
			result.add(s.pop());
		}
		return result;
	}

	private void topologicalSorting(GraphNode node, Stack<GraphNode> s, LinkedHashSet<GraphNode> recorded,LinkedHashSet <GraphNode > cycleChecker) throws Exception {
		if (cycleChecker.contains(node)) throw new java.lang.Exception ("Cycle!! Ugh...");
		if (recorded.contains(node)) return;
		
		recorded.add(node);
		cycleChecker.add(node);
		for (GraphNode neighbor:node.neighbors){
			topologicalSorting(neighbor, s,recorded,cycleChecker);
		}
		s.push(node);
		cycleChecker.remove(node);
	}
}


public class GTopologicalSorting {

	public static void main(String[] args) throws Exception {
		DirectedGraph g = DirectedGraph.getInstance();

		g.addNode (5);
		g.addNode (7);
		g.addNode (8);
		g.addNode (12);
		g.addNode (9);
		g.addNode (4);
		g.addNode (3);
		g.addNode (2);
		g.addNode (1);
		
		g.addLink (4,5);
		g.addLink (4,12);
		g.addLink (5,12);
		g.addLink (5,7);
		g.addLink (7,8);
		g.addLink (12,9);
		g.addLink (1,3);
		g.addLink (1,2);
		g.addLink (2,4);
		g.addLink (3,4);
		g.addLink (8,1);
		
		ArrayList<GraphNode> ts = g.topologicalSorting();

		for ( GraphNode gn:ts){
			System.out.println(gn.val);
		}
	}

}
