package fbExercises;

import java.util.LinkedList;
import java.util.Queue;

import interviewBit.TreeNode;;

/**
 * 
 * Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.

 * @author mrincodi
 * 2016-11-12
 * Comment: FB/s solution. This is in-place, because they don't create new nodes,
 * but on the other hand, they use a queue.
 * This solution is not related to the hint, though.
 */
public class FlattenFB {
	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	public TreeNode flatten(TreeNode A) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		preorder(queue, A);

		if (queue.isEmpty())
			return A;

		TreeNode node = queue.remove();
		TreeNode next;
		A = node;

		while (!queue.isEmpty()) {
			next = queue.remove();
			node.left = null;
			node.right = next;
			next.left = null;
			node = next;
		}

		return A;

	}

	public void preorder(Queue<TreeNode> queue, TreeNode node) {

		if (node == null)
			return;

		queue.add(node);
		preorder(queue, node.left);
		preorder(queue, node.right);

	}


}
