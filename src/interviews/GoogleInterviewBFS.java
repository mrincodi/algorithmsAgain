package interviews;

public class GoogleInterviewBFS {

	
	void setNextInLevels ( Node root ){
		if ( root == null ) return;

		java.util.Queue <Node> nodeQueue = new java.util.LinkedList< Node > ();
		
		nodeQueue.add(root);
		nodeQueue.add(null);
		
		while (!nodeQueue.isEmpty()){
			Node node = nodeQueue.remove();
			
			if ( node != null ){
				node.nextInLevel = nodeQueue.peek();
				//Add children.
				if (node.left!= null ) nodeQueue.add(node.left);
				if (node.right!= null ) nodeQueue.add(node.right);
			}
			else {
				if ( !nodeQueue.isEmpty())
					nodeQueue.add(null);
			}
		}
	}
	
	public static void main(String[] args) {

		Node n = new Node (7);

		n.left = new Node ( 9);
		n.right = new Node ( 12);

		n.left.left = new Node ( 15);
		n.left.right = new Node ( 18);
		n.right.right = new Node ( 24);
		n.left.left.left = new Node  (40 );
		n.right.right.left = new Node ( 49);

		new GoogleInterviewBFS().setNextInLevels(n);
		
		System.out.println("");

		n.printLevels();
	}


}
