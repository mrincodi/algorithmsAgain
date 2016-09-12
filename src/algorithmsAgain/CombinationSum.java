package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
Example, 
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 
 *
 * @author mrincodi
 * 2016-08-23
 * Comment: The good news is that it works. I think that I could have ignored the
 * thisValueSeveralTimes part, and just call the method again with the original,
 * not-truncated list. InterviewBit's solution is much shorter, but they go over
 * all the previous values before adding a new one (I am using a sweet LinkedHashSet).
 *
 */
public class CombinationSum {

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		if ( a == null ) return new ArrayList<ArrayList<Integer>> ();
		Collections.sort ( a );

		ArrayList<ArrayList<Integer>> result = combinationSum2(a,  b);

		if ( result.size() <= 1 ) return result;

		LinkedHashSet < ArrayList<Integer> >lhs = new LinkedHashSet < ArrayList<Integer> >();

		for ( ArrayList<Integer> list : result){
			if (!lhs.contains (list)) lhs.add(list);
		}
		
		result = new ArrayList<ArrayList<Integer>> ();
		for ( ArrayList<Integer> list : lhs ){
			result.add(list);
		}

		return result;
	}


	private ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> numbers, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		if ( numbers.size ()  == 0  || target <= 0 ) return result;

		int thisValue = numbers.get (0);

		if ( thisValue > target ) return result;

		if ( numbers.size () == 1 && thisValue == target ){
			result.add ( new ArrayList <Integer > ( Arrays.asList ( numbers.get(0) )));
			return result;
		}

		ArrayList <Integer > thisValueSeveralTimes = new ArrayList <Integer > ();

		//Add thisValue as many times you can as long as you're less (or equal) to target.
		int total = 0;
		while (total <= target){
			thisValueSeveralTimes.add (thisValue);
			total = total + thisValue;
		}

		thisValueSeveralTimes.remove(0);

		//Now, find out if we "got" to the target only by adding thisValue.
		if (total == target + thisValue){
			//Awesome!
			result.add (  new ArrayList <Integer > (thisValueSeveralTimes ) );
			if ( thisValueSeveralTimes.size() == 1 // Numbers after this one will be bigger than thisValue.
					|| numbers.size() == 1 // No more numbers left.
					) return result;
		}

		//Now, start removing yourself and calling the method again.
		int numTimes=thisValueSeveralTimes.size();
		ArrayList <Integer > listWithoutThisValue = new ArrayList <Integer > (numbers.subList (1,numbers.size()));              

		while (numTimes > 0 ){
			ArrayList <ArrayList <Integer >> resultWithRestOfNumbers = combinationSum2( listWithoutThisValue, target - ( numTimes * thisValue ) );     

			if ( resultWithRestOfNumbers.size() != 0 ){
				// I got some results!

				for ( ArrayList <Integer > partialResult: resultWithRestOfNumbers){
					ArrayList <Integer > OKEntry = new ArrayList <Integer> (thisValueSeveralTimes);
					OKEntry.addAll (partialResult);
					result.add ( OKEntry );
				}
			}
			numTimes--;
			thisValueSeveralTimes.remove(0);
		}

		//Finally, call this method without thisNumber, but with the correct target.
		result.addAll (combinationSum2(listWithoutThisValue, target));

		//Whew!
		return result;
	}

	public static void main(String[] args) {
		ArrayList <Integer> numbers = new ArrayList <Integer> ( Arrays.asList(8, 10, 6, 11, 1, 16, 8));
		int target = 28;
		ArrayList<ArrayList<Integer>> result = new CombinationSum().combinationSum(numbers,target);
		for ( ArrayList <Integer> al: result){
			for ( int val: al){
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
