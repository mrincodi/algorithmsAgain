package other;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * From https://www.quora.com/What-algorithm-questions-were-you-asked-at-an-Amazon-Microsoft-Google-interview
 * Calculate all permutations for an array of integers.

For example: Given {3, 5, 8} - Output should be: { 3, 5, 8 }, { 3, 8, 5 }, { 5, 3, 8 }, { 5, 8, 3 }, { 8, 5, 3 }, { 8, 3, 5 }


 * @author mrincodi
 *
 */
public class Permutations {
	ArrayList < ArrayList <Integer> > permutations ( ArrayList <Integer> numbers ) {
		ArrayList < ArrayList <Integer> > result = new ArrayList < ArrayList <Integer> > ();

		if ( numbers.size() == 0 ) return result;
		if ( numbers.size() == 1 ){
			result.add ( new ArrayList <Integer> ( Arrays.asList ( numbers.get(0))));
			return result;
		}

		for ( int i = 0; i < numbers.size() ; i++ ){
			ArrayList <Integer> reducedNumbers = new ArrayList <Integer> ( numbers );
			reducedNumbers.remove (i);
			ArrayList < ArrayList <Integer> > partialResult = permutations ( reducedNumbers );

			for ( int j = 0; j < partialResult.size(); j++ )
				partialResult.get(j).add(0, numbers.get(i));

			result.addAll (partialResult);
		}
		return result;
	}
	
	public static void main ( String [] args ){
		ArrayList <Integer> numbers = new ArrayList <Integer> ( Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		ArrayList < ArrayList <Integer> > result = new Permutations().permutations(numbers);
		
		for ( ArrayList <Integer> r: result)
			System.out.println(r);
		System.out.println(result.size());

	}
}
