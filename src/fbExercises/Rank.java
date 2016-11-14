package fbExercises;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * 
 * Given a string, find the rank of the string amongst its permutations sorted lexicographically. 
Assume that no characters are repeated.

Example :

Input : 'acb'
Output : 2

The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
The answer might not fit in an integer, so return your answer % 1000003

 * @author mrincodi
 * 2016-11-12
 *
 */
public class Rank {

	public int findRank(String a) {
		long n = (long) a.length ();
		if ( n <=1 ) return (int) n;

		char [] chars = a.toCharArray ();
		long result = 0;
		Arrays.sort (chars);
		ArrayList <Character> charsList = new ArrayList <Character> ();
		for ( char c:chars)
			charsList.add(c);
		
		for ( int i = 0; i < a.length (); i++){
			char c = a.charAt (i);
			long pos = (long) charsList.indexOf (c);
			long thisPos = ((factorial (n-1)%1000003L) * pos)%1000003L;
			result += thisPos %1000003L;
			n=n-1;
			charsList.remove ( charsList.indexOf (c));
		}
		return (int) ((result+1)%1000003L);
	}

	public long factorial (long n ){
		return n<=0?1:(n*factorial(n-1))%1000003L;
	}
	
	public static void main(String[] args) {
		String s = "ZCSFLVHXRYJQKWABGT";
		
		int r = new Rank().findRank(s);
		System.out.println(r);

	}

}
