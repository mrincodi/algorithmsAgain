package googleInterview;

import java.util.ArrayList;

class Node {
	int val;
	Node nextInLevel;
	Node left;
	Node right;

	Node (int val ) { this.val=val; this.left=null; this.right=null;this.nextInLevel=null;} 
}

public class GoogleInterview {


	void setNextInLevels ( Node root ){
		if ( root == null ) return;

		ArrayList <Node>  currentLevelArrayList = new ArrayList < Node > ();

		ArrayList  <Node> childLevelArrayList = new ArrayList < Node > ();

		childLevelArrayList.add(root);

		while ( !childLevelArrayList.isEmpty () ){

			currentLevelArrayList = childLevelArrayList;

			childLevelArrayList = new ArrayList < Node > ();
			
			for ( Node currentNode : currentLevelArrayList ){
				if ( currentNode.left != null ) childLevelArrayList.add ( currentNode.left);
				if ( currentNode.right != null ) childLevelArrayList.add ( currentNode.right );
			}

			for ( int i = 0 ; i < childLevelArrayList.size() -1; i++)
				childLevelArrayList.get(i).nextInLevel = childLevelArrayList.get (i + 1);

			if ( childLevelArrayList.size() > 0 )
					childLevelArrayList.get(childLevelArrayList.size()-1).nextInLevel = null;

		}

	}

	public static void main(String[] args) {

		Node n = new Node (7);

		n.left = new Node ( 9);
		n.right = new Node ( 12);

		new GoogleInterview().setNextInLevels(n);
		System.out.println("");

	}

}
