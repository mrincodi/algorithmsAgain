package algorithmsAgain;

import java.util.LinkedList;
import java.util.Queue;

// Definition for binary tree with next pointer.
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}


/**
 * 
 * 
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 Note:
You may only use constant extra space.
Example :

Given the following binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 Note 1: that using recursion has memory over
 
 * @author mrincodi
 * 2016-11-19
 * Comment: I will never forget you... I know this one by heart now. Queues, baby.
 *
 */
public class PopulateNextRightPointersTree {

	/**
	 * Definition for binary tree with next pointer.
	 * public class TreeLinkNode {
	 *     int val;
	 *     TreeLinkNode left, right, next;
	 *     TreeLinkNode(int x) { val = x; }
	 * }
	 */
	public void connect(TreeLinkNode root) {

		if ( root == null ) return;
		if ( root.left == null && root.right == null ){
			root.next = null;
			return;
		}

		Queue <TreeLinkNode> q = new LinkedList <TreeLinkNode> ();

		q.add(root);
		q.add (null);

		while (!q.isEmpty() ){
			TreeLinkNode node = q.remove();
			if (node != null ){
				node.next = q.peek();
				if ( node.left != null) q.add(node.left);
				if ( node.right != null) q.add(node.right);
			}
			else {
				if ( !q.isEmpty () ){
					q.add(null);
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
