package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

public class AllUniquePermutations {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		if ( a == null || a.size() == 0 ) return result;

		//Collections.sort (a);

		TreeMap <Integer, Integer> t = new TreeMap <Integer, Integer> ();

		for ( int i = 0; i < a.size (); i++ ){
			if ( t.containsKey (a.get(i))){
				t.put(a.get(i),t.get(a.get(i))+1);
			}
			else
				t.put(a.get(i),1);
		}

		return permute (t);
	}

	private ArrayList<ArrayList<Integer>> permute(TreeMap <Integer, Integer> t) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();

		if ( t.isEmpty ()) return result;

		if ( t.size()==1) {
			Iterator <Integer> iter = t.keySet().iterator();
			int key = iter.next();
			if (t.get(key) == 1){
				result.add( new ArrayList <Integer> ( Arrays.asList(key)));
				return result;
			}
		}

		Iterator <Integer> iter = t.keySet().iterator();

		while (iter.hasNext()){
			ArrayList<Integer> entry = new ArrayList<Integer>();
			int number = iter.next();
			entry.add (number);
			TreeMap <Integer, Integer> miniT = new TreeMap <Integer, Integer> (t);
			if ( miniT.get(number) > 1 )
				miniT.put (number,miniT.get(number) - 1);
			else
				miniT.remove (number);

			ArrayList<ArrayList<Integer>> partialResult = permute (miniT );
			for ( int i = 0; i < partialResult.size(); i++ ){
				partialResult.get(i).add(0, number);
				result.add (partialResult.get(i));
			}
		}
		return result;
	}


	public static void main(String[] args) {
		ArrayList <Integer> a = new ArrayList <Integer> ( Arrays.asList(1,1,2,3));
		ArrayList<ArrayList<Integer>> result = new AllUniquePermutations().permute(a);
		System.out.println(result);
	}

}
