package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {


	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {

		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>> ();

		if (a.size() == 0 ) return results;
		
		if (a.size() == 1 ) {
			ArrayList<Integer> element = new ArrayList<Integer> ();
			element.add(a.get(0));
			results.add(element);
			return results;
		}

		for ( int i = 0; i < a.size(); i++ ){
			int current = a.get(i);
			//System.out.println (current);

			ArrayList<Integer> b = (ArrayList<Integer>) a.clone();
			b.remove ( i );

			//System.out.println ("Wepa");
			ArrayList<ArrayList<Integer>> subResults = permute (b);

			for ( int j = 0; j < subResults.size(); j++ ){
				subResults.get(j).add(0,current);
				results.add(subResults.get(j));
			}
		}
		return results;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> a = new ArrayList <Integer> ();
		
		a.addAll( Arrays.asList(3, 4, 5));

		 ArrayList<ArrayList<Integer>> results = new Permutations().permute (a);

		 for ( int i = 0; i < results.size(); i++ ){
			 for ( int j = 0 ; j < results.get(i).size(); j++){
				 System.out.print(results.get(i).get(j) + " ");
			 }
			 System.out.println();
		 }
	}

}
