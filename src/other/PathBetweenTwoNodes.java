package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 * Design an  algorithm  to  find  a  path  from  one  node  in  a  binary  tree  to  another.
 * @author mrincodi
 * 2016-11-30
 * Comment: from http://courses.csail.mit.edu/iap/interview/Hacking_a_Google_Interview_Handout_3.pdf
 *
 */
public class PathBetweenTwoNodes {

	public ArrayList<Integer> getPath ( int a, int b, TreeNode tree){
		ArrayList<Integer> path1 = findNode (a, tree);
		ArrayList<Integer> path2 = findNode (b, tree);

		if ( path1 == null || path2 == null) return null;

		//Remove common nodes save the last common one.
		int i = 0;
		for (; i <Math.min(path1.size(),path2.size()) - 1;i++){
			if ( path1.get(i) == path2.get(i) ){
				if ( path1.get(i+1) != path2.get(i+1)) break;
			}
		}

		path1=new ArrayList<Integer>(path1.subList(i,path1.size()));
		path2=new ArrayList<Integer>(path2.subList(i,path2.size()));
		
		path1.remove(0);
		Collections.reverse(path1);
		path1.addAll(path2);

		return path1;
	}


	private ArrayList<Integer> findNode (int a, TreeNode tree){
		if ( tree==null) return null;
		if (tree.val == a ) return new ArrayList<Integer> (Arrays.asList(a));
		ArrayList<Integer> possiblePath = findNode (a, tree.left);
		if ( possiblePath != null){
			possiblePath.add (0,tree.val);
			return possiblePath;
		}
		possiblePath = findNode (a, tree.right);
		if ( possiblePath != null){
			possiblePath.add (0,tree.val);
			return possiblePath;
		}
		return null;
	}



	public static void main(String[] args) {
		
		TreeNode t = new TreeNode (17);
		t.left = new TreeNode (6);

		t.left.left = new TreeNode (3);
		t.left.left.left = new TreeNode (1);
		t.left.right = new TreeNode (12);
		t.left.right.left = new TreeNode (9);
		t.left.right.right = new TreeNode (15);
		t.right = new TreeNode (46);
		t.right.right = new TreeNode (56);
		t.right.right.left = new TreeNode (48);

		ArrayList<Integer> path = new PathBetweenTwoNodes().getPath(1, 15, t);
		System.out.println(path);
		
		System.out.println("Hola, Kamila. Estás loquita. ;)");
		
	}

}
