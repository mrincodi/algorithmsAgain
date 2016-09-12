package other;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Subsets of given size!
 * 2016-08-21
 * @author mrincodi
 *
 */
public class SetsOfSizeX {

	ArrayList < ArrayList <Integer > > sets (int size, ArrayList <Integer> numbers ){

		if ( numbers.size() < size ) return null;

		ArrayList < ArrayList <Integer > >  result = new ArrayList < ArrayList <Integer > >  ();

		if (size == 1) {
			for ( int val: numbers)
				result.add( new ArrayList <Integer > (Arrays.asList(val)));

			return result;
		}

		for ( int startIndex = 0; startIndex < numbers.size() - size + 1; startIndex++){
			ArrayList < ArrayList <Integer > > smallerSets = 
					sets ( size - 1, new ArrayList <Integer> (numbers.subList(startIndex + 1, numbers.size())));

			for ( ArrayList <Integer> smallerSet : smallerSets){
				smallerSet.add(0,numbers.get(startIndex));
			}
			result.addAll( smallerSets);
		}

		return result;
	}
	
	public static void main(String[] args) {
		int size = 10;
		ArrayList <Integer> numbers = new ArrayList <Integer> ( Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
		ArrayList < ArrayList <Integer > > theSets = new SetsOfSizeX().sets ( size, numbers );

		System.out.println();
		for (  ArrayList <Integer > aSet : theSets){
			for (int val : aSet ){
				System.out.print(val + " ");
			}
			System.out.println();
		}

	}
}
