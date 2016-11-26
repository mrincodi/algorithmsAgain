package interviewBit;

public class AdjacencyListGraph implements Graph {

	private java.util.HashMap <Integer, java.util.ArrayList < Integer> > map ;

	public AdjacencyListGraph (){
		map = new java.util.HashMap <Integer, java.util.ArrayList < Integer> >  ();
	}

	public void addVertex ( int value ){
		map.put ( new Integer (value), new java.util.ArrayList < Integer > ()); //In HashMaps it's put, not set. What about HashSets and others?
	}

	/**
	 * TODO: Better to call "RemoveEdge" here, after removing the vertex.
	 */
	public void removeVertex ( int value ){
		// First, remove the entry in the map.
		map.remove ( value );
		//Now, we�ll have to look for the key in all the lists, and remove it.
		java.util.Iterator < java.util.Map.Entry <Integer, java.util.ArrayList < Integer> > > it = map.entrySet().iterator();
		while (it.hasNext ()){
			java.util.Map.Entry  <Integer, java.util.ArrayList < Integer> > pair = it.next();
			java.util.ArrayList <Integer> adjacencyList= pair.getValue();

			adjacencyList.remove (adjacencyList.indexOf ( value ));
		}
	}

	public java.util.ArrayList <Integer> getBFS ( int start ){
		java.util.ArrayList <Integer> result = new java.util.ArrayList <Integer> ();
		// How to implement a FIFO in Java? Is there a structure for this already? I can certainly implement it with an ArrayList.
		// We use a FIFO for BFS:
		java.util.Queue <Integer> q = new java.util.LinkedList <Integer> (); //Does this work only on LinkedList? Yes (and others, but not ArrayList).

		if ( ! map.containsKey ( start ) ) return null;

		q.add ( start );
		while ( q.size () != 0 ){  //TODO: Confirm method name.
			int currentNode = q.remove ();
			result.add (currentNode );
			java.util.ArrayList < Integer > destinations = map.get (currentNode);
			for (int i = 0; i < destinations.size (); i++ ){
				if ( !result.contains ( destinations.get (i) ) && !q.contains(destinations.get (i))) //OJO a los constraints.
					q.add ( destinations.get (i));
			}
		}
		return result;
	}
	
	public java.util.ArrayList <Integer> getDFS ( int value ){
		java.util.ArrayList <Integer> result = new java.util.ArrayList <Integer> ();
		java.util.Stack <Integer> s = new java.util.Stack <Integer > ();

		if (!map.containsKey (value )) return null ;

		s.push (value );
		result.add (value );

		while ( s.size () != 0 ){
			value = s.peek ();
			java.util.ArrayList <Integer> neighbors = map.get ( value);
			boolean neighborFound = false;
			for ( int i = 0; i < neighbors.size() && !neighborFound ;i++){
				int neighbor = neighbors.get (i);
				if ( !result.contains ( neighbor)){
					result.add (neighbor );
	 				s.push ( neighbor );
					neighborFound = true;
				}
			}

			if ( !neighborFound )
				s.pop ();
		}
		return result;	//Don't forget to return!
	}

	// This is an undirected graph.
	public void addEdge ( int value1, int value2 ){
		java.util.ArrayList <Integer> value1Map = map.get ( value1 ); // Always remember to put the type inside java.util.ArrayList and others. TODO: How do you call this type of structures?
		java.util.ArrayList <Integer> value2Map = map.get ( value2 );

		//No parallel links in this implementation.
		if ( !value1Map.contains (value2)){
			value1Map.add (value2);
			value2Map.add (value1);
		}
	}

	public static void main ( String [] args ){
		Graph g = new AdjacencyListGraph();

		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		g.addVertex(8);
		g.addVertex(9);
		
		g.addEdge(1,2);
		g.addEdge(1,9);
		g.addEdge(9,8);
		g.addEdge(2,4);
		g.addEdge(4,5);
		g.addEdge(8,3);
		g.addEdge(8,6);
		g.addEdge(6,7);
				
		//g.removeEdge(1,2);
		
		java.util.ArrayList <Integer> bfs = g.getBFS (1);
		java.util.ArrayList <Integer> dfs = g.getDFS (1);
		
//		for ( int i = 0; i < bfs.size(); i++){
//			System.out.println(bfs.get(i));
//		}

		for ( int i = 0; i < dfs.size(); i++){
			System.out.println(dfs.get(i));
		}
		
	}
}

