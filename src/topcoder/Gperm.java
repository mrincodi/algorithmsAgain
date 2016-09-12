package topcoder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Gperm {

	HashSet <Integer> allNodes = new HashSet <Integer> ();
	HashMap <HashSet<Integer>,Integer> dp = new HashMap <HashSet<Integer>,Integer>();

	public int countfee ( int []x, int [] y ){
		HashSet <Integer> painted = new HashSet <Integer> ();

		//Prepare the hashset.
		for ( int i=0;i<x.length;i++){
			allNodes.add(x[i]);
			allNodes.add(y[i]);
		}
		return numfee (x,y,0,painted);
	}

	public int numfee(int[] x, int[] y, int carriedCost, HashSet<Integer> painted) {
		
		if (painted.size() == allNodes.size()) return 0;
		
		if (dp.containsKey(painted)) return dp.get(painted);
		
		Iterator <Integer> iter = allNodes.iterator();

		int cheapestPainting = Integer.MAX_VALUE;
		while (iter.hasNext()){
			int node = iter.next();
			if ( painted.contains(node)) continue;
			//Get how much would it be painting this node.
			int thisCost = 0;
			for ( int i = 0; i < x.length; i++){
				int thisX = x[i];
				int thisY = y[i];
				if (thisX == node && thisY == node) thisCost += 1;
				else if (thisX == node && painted.contains(thisY)) thisCost += 1;
				else if (thisY == node && painted.contains(thisX)) thisCost += 1;
			}
			HashSet <Integer> painted2 = new HashSet <Integer> (painted);
			painted2.add(node);
			int thisPainting = thisCost + carriedCost + numfee (x,y,thisCost+carriedCost,painted2);
			cheapestPainting = Math.min( cheapestPainting, thisPainting);
		}
		dp.put(painted, cheapestPainting);
		return cheapestPainting;
	}

	public static void main(String[] args) {
		int [] x = {45,28,42,5,27,27,42,36,14,27,19,42,24,27,8,31,24,27,14,28};
		int [] y = {45,27,45,8,34,34,28,0,11,42,24,19,14,31,45,42,14,24,28,27};

		System.out.println(new Gperm().countfee(x,y));

	}

}

