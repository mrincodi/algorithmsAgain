package fbExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class PrimeSum {


	LinkedHashSet <Integer> primes = new LinkedHashSet<Integer> ();

	public ArrayList<Integer> primesum(int a) {

		primes.add(2);

		ArrayList<Integer> result = new ArrayList<Integer> ();

		if ( a == 4) return new ArrayList<Integer> (Arrays.asList(2,2));

		//First, get the primes <= to a/2. Save them in a HashSet (primes)
		//Then, continue generating prime numbers (p), but look for a-p in the hashset of primes.
		//If it''s found, return it.
		int i=3;
		for ( ; i <= a/2 -1; i=i+2){
			if ( isPrime (i) ) primes.add(i);
		}

		//if (primes.contains (a/2)) return new ArrayList<Integer> (Arrays.asList(a/2, a/2));

		//Now, start looking for the differences in the hashset.
		for ( ; i < a; i=i+2){
			if ( isPrime (i)){
				primes.add(i);
				if (primes.contains (a-i) ) result= new ArrayList<Integer> (Arrays.asList(a-i,i));
			}
		}
		return result;
	}

	boolean isPrime (int i){
		int sqrtI = (int) Math.sqrt (i)+1;

		for (int p:primes){
			if (i%p==0) return false;
			if (p > sqrtI ) return true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int num = 10;
		ArrayList <Integer> result = new PrimeSum().primesum(num);
		
		System.out.println(result);

	}

}
