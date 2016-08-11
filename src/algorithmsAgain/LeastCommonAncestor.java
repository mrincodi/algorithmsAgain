package algorithmsAgain;

/**
 * 
 * 
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.


 * @author mrincodi
 * 2016-08-09
 * Comment: Very difficult without hints! This solution works, but it's 
 * convoluted and not elegant (a bunch of if's and two global variables).
 * The brute force solution was this: Pick every node. For every node, 
 * search for val1, val2 in the subtree. If val1 and val2 are both found 
 * in the subtree, then the current node is definitely one of the ancestors. 
 * Also track the depth of the current node. Pick the qualifying node of 
 * highest depth.
 * Even a better idea: use an arrayList and save the current path to the node 
 * in it. When both are found, just return the last element of the intersection
 * of both lists!
 *
 */
public class LeastCommonAncestor {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	boolean val1Found=false;
	boolean val2Found=false;

	public int lca(TreeNode a, int val1, int val2) {

		int result = -1;
		
		if ( a==null ) return -1;

		if ( !val1Found && !val2Found){

			if (a.val != val1 && a.val != val2 ){
				//Call left.
				result = lca (a.left, val1, val2);

				if (val1Found && val2Found) return result;

				if (val1Found){
					//Look for val2 in your right subtree. If found, you're the lca.
					result = lca (a.right, val1, val2);

					if (val2Found){
						return a.val;
					}
				}

				if (val2Found){
					//Look for val2 in your right subtree. If found, you're the lca.
					result = lca (a.right, val1, val2);

					if (val1Found){
						return a.val;
					}
				}

				result = lca (a.right, val1, val2);

				return result;

			}

			if (a.val == val1){
				val1Found=true;

				//Both values may be the same!
				if (val1==val2) {
					val2Found=true;
					return a.val;
				}

				//val2 *may* be below me. Look for it.

				result = lca ( a.left, val1, val2);

				if (val2Found)
					return a.val;

				result = lca ( a.right, val1, val2);
				if (val2Found)
					return a.val;

				return -1;
			}

			if (a.val == val2){
				val2Found=true;
				//val2 *may* be below me. Look for it.

				result = lca ( a.left, val1, val2);

				if (val1Found)
					return a.val;

				result = lca ( a.right, val1, val2);
				if (val1Found)
					return a.val;

				return -1;
			}
		}

		if (val1Found && !val2Found ){
			if (a.val == val2){
				val2Found = true;
				return -1;  //Father is somewhere else.
			}
			result=lca(a.left,val1,val2);
			if ( val2Found ) return -1;
			result=lca(a.right,val1,val2);
			return -1; //Even if found or not, I am not the lca.
		}

		if (!val1Found && val2Found ){
			if (a.val == val1){
				val1Found = true;
				return -1;  //Father is somewhere else.
			}
			result=lca(a.left,val1,val2);
			if ( val1Found ) return -1;
			result=lca(a.right,val1,val2);
			return -1; //Even if found or not, I am not the lca.
		}

		//If both are found should never happen.
		return -1;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode t = new TreeNode (7);
		TreeNode t1 = new TreeNode (5);
		TreeNode t2 = new TreeNode (9);
		TreeNode t3 = new TreeNode (2);
		
		
		t.left=t1;
		t.right=t2;
		t1.left=t3;
		
		int lca = new LeastCommonAncestor ().lca(t, 2,9);
		
		System.out.println(lca);
	}

}
