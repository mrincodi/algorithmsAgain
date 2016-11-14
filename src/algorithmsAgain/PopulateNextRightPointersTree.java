package algorithmsAgain;

// Definition for binary tree with next pointer.
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}

public class PopulateNextRightPointersTree {

	public void connect(TreeLinkNode root) {

		if ( root == null) return;

		TreeLinkNode parentPointer = root;

		TreeLinkNode childPointer = null;

		TreeLinkNode startChildren = null;
		
		TreeLinkNode lastStartChildren = parentPointer;

		boolean end=false;

		// First iteration.
		TreeLinkNode leftChild = parentPointer.left;
		TreeLinkNode rightChild = parentPointer.right;

		//		if ( leftChild == null && rightChild == null ) return;
		//		
		//		if ( leftChild  != null && rightChild == null ) {
		//			startChildren = leftChild;
		//			childPointer = leftChild;
		//		}
		//		else if ( leftChild == null && rightChild != null ) {
		//			startChildren = rightChild;
		//			childPointer = rightChild;
		//		}
		//		

		while ( !end ){

			leftChild = parentPointer.left;
			rightChild = parentPointer.right;

			if ( leftChild != null && rightChild == null ) {
				if ( startChildren == null){
					startChildren = leftChild;
					childPointer = startChildren;
				}
				else {
					childPointer.next = leftChild;
					childPointer=childPointer.next;
				}
			}

			else if ( leftChild == null && rightChild != null ) {
				if ( startChildren == null ){
					startChildren = rightChild;
					childPointer = startChildren;
				}
				else {
					childPointer.next = rightChild;
					childPointer=childPointer.next;
				}
			}
			else if ( leftChild != null && rightChild != null ) {
				if ( startChildren == null ){
					leftChild.next = rightChild;
					startChildren = leftChild;
					childPointer = rightChild;
				}
				else {
					leftChild.next = rightChild;
					childPointer.next = leftChild;
					childPointer = rightChild;
				}
			}

			parentPointer = parentPointer.next;

			if ( parentPointer == null ){
				parentPointer =startChildren;
				startChildren = null;
				
				if ( parentPointer == lastStartChildren )
					end = true;
				else{
					lastStartChildren = parentPointer;
				}
			}
		}
	}

	public static void main(String[] args) {
		TreeLinkNode t = new TreeLinkNode (7);
		t.left = new TreeLinkNode (1);
		t.left.left = new TreeLinkNode (0);
		t.left.right = new TreeLinkNode (4);
		t.right = new TreeLinkNode (11);
		t.right.left = new TreeLinkNode (10);
		t.right.right = new TreeLinkNode (40);



		new PopulateNextRightPointersTree().connect(t);

		System.out.println(t.val);

	}

}
