package interviews;

class Node {
	int val;
	Node nextInLevel;
	Node left;
	Node right;

	Node (int val ) { this.val=val; this.left=null; this.right=null;this.nextInLevel=null;} 
	
	public void printLevels (){
		Node node = this;
		Node nextNode = null;
		while ( node != null){
			System.out.print(node.val + " ");

			if ( nextNode == null ){
				if (node.left!= null)nextNode=node.left;
				else if (node.right!= null)nextNode=node.right;
			}
			
			node = node.nextInLevel;
		}
		System.out.println();
		if ( nextNode!= null ) nextNode.printLevels();

	}

	
}

