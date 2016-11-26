package interviewBit;

/**
 * 
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach�s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 

 */
import java.util.ArrayList;
import java.util.HashSet;

public class PrimeSum {
    public ArrayList<Integer> primes = new ArrayList<Integer> ();
    public HashSet <Integer> primesSet = new HashSet <Integer> ();
    
    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> solution = new ArrayList<Integer> ();
        
       findPrimes (a);
        
        for ( int i = 0; i < primes.size(); i++ ){
        	int xx = primes.get(i);
            int yy = a - primes.get(i);
            
        	// System.out.println("Analizando " + xx + " y " + yy );
            if (primesSet.contains(yy)){ 
                solution.add (xx);
                solution.add (yy);
 
                //System.out.println(xx + " " + yy);
                return solution;
            }
        }
        return solution;
    }

    public void findPrimes (int n ){
        primes.add(2);
        primesSet.add(2);

        for ( int i =3; i < n; i+=2){
            //Go over all the previously found primes. If it has no dividends, add to list of primes.
            boolean mayBePrime=true;
            int sqrt = (int) Math.sqrt(i) + 1;
            int j = 0;
            for ( ; mayBePrime && j < primes.size() && primes.get(j) < sqrt; j++ ){
                if ( i % primes.get(j) == 0 ) mayBePrime=false;
            }
            //System.out.println (j);
            if (mayBePrime) {
            	primes.add(i);
            	primesSet.add(i);
            }
        }
//         for ( int j = 0; j < primes.size() ; j++ ){
//             System.out.println (primes.get(j));
//         }
    }
    
}
