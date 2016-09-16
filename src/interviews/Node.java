package interviews;

class Node {
	int val;
	Node nextInLevel;
	Node left;
	Node right;

	Node (int val ) { this.val=val; this.left=null; this.right=null;this.nextInLevel=null;} 
}

