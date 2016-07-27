package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(ArrayList<Integer> a) {
		if ( a.size () <= 1 ) return a.size();
		int i = 0, j = 1;

		while ( j < a.size ()){

			int v1 = a.get(i);
			int v2 = a.get(j);
//				            System.out.println ( "i = " + i + " j = " + j + 
//				            " a.get(i)= " + a.get(i) + " a.get(j)= " + a.get(j));
			if (v1 != v2){
				
				//System.out.println ( "Diferentes!" );
				a.set(i+1,v2);
				i++;
				j++;
			}
			else {
				//System.out.println ( "SOlo j");
				j++;
			}
		}
		// Now, truncate the ArrayList. is it possible?
		//a.subList(0, i + 1).clear();

		//System.out.println ( "E i vale " + i);
		return i + 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Integer> a = new ArrayList  <Integer> ( Arrays.asList(5000,5000,5000,5000));
		
		int q = new RemoveDuplicatesFromSortedArray().removeDuplicates(a);
		
		System.out.println(q);


	}

}
