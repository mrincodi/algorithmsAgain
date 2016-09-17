package interviews;

import java.util.ArrayList;


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

		n.left.left = new Node ( 15);
		n.left.right = new Node ( 18);
		n.right.right = new Node ( 24);
		n.left.left.left = new Node  (40 );
		n.right.right.left = new Node ( 49);
		
		new GoogleInterview().setNextInLevels(n);
		
		System.out.println("");

		n.printLevels();
	}

}
