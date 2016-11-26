package interviewBit;

/**
 * Works but takes too long. And it's horrible.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class GreatestCommonDivisorHorrible {

	    ArrayList <Integer> primes = new ArrayList <Integer> (); 
	    
	    void printy (String qq){
	        //System.out.println (qq);
	    }
	    
		public int gcd(int a, int b) {

	        int result = 1;
	    
	        int max;
	        int min;
	    
	        if ( a > b){
	            max = a;
	            min = b;
	        }
	        else {
	            max = b;
	            min = a;
	        }
	        
	        if ( min == 0 ) return max;

	        //Get all the primes until the sqrt of min.
	        getPrimes (min/2 + 1);
	    
	        //Get the prime factors. Remember always to add yourself iif you are not divisible over any of the primes.
	        HashMap <Integer, Integer> factorsOfMin = getFactors ( min );

	        getPrimes (max/2 + 1);
	    
	        HashMap <Integer, Integer> factorsOfMax = getFactors ( max );

	        //I need to find the intersection between the two sets.
	        
	        java.util.Iterator iter = factorsOfMin.keySet().iterator();
	        
	        printy ( "Factores de " + min);
	            
	        while (iter.hasNext()){
	            int factor = (int) iter.next ();
	            printy ( factor + " " + factorsOfMin.get(factor));
	        }
	        
	        iter = factorsOfMax.keySet().iterator();
	        
	        printy ( "Factores de " + max);
	            
	        while (iter.hasNext()){
	            int factor = (int) iter.next ();
	            printy( factor + " " + factorsOfMax.get(factor));
	        }
	        
	        iter = factorsOfMin.keySet().iterator();
	        
	        
	        while (iter.hasNext()){
	            int factor = (int) iter.next ();
	            if (factorsOfMax.containsKey (factor)){
	                int numTimes = Math.min (factorsOfMin.get(factor), factorsOfMax.get(factor));
	                result = result * (int) Math.pow (factor, numTimes);
	            }
	        }

	        return result;        

		}
		
		//Get all primes until n.
		void getPrimes (int n){
		    printy ( "Hallemos los primos antes de " + n);
		    if ( primes.size() == 0 ) { primes.add (2); primes.add(3); }

		    for (int i = primes.get ( primes.size () - 1 ) + 2; i < n; i +=2){
		        printy ("Voy por " + i);
	            boolean mayBePrime= true;
		        for ( int j = 0; mayBePrime && j < primes.size () ; j++ ){
		            printy("en el ciclo en la pos "+ j + " con el primo " + primes.get(j) );
		            if (i%primes.get(j)==0) {
		                printy ( "HOLAAAAAAAA!!" + primes.get(j) );
		                mayBePrime=false;
		            }
		        }

		        if (mayBePrime) { 
		            primes.add(i); 
		            printy ( i + " es primo ");
		        }
		    }
		}
		
		HashMap <Integer, Integer> getFactors ( int n ){
		    HashMap <Integer, Integer> factors = new HashMap <Integer, Integer> ();
		    //int raiz = (int) Math.sqrt (n) + 1;
		    int mitad = n/2+1;
		    printy( "Tengo " + primes.size() );
	        for ( int i = 0; i < primes.size() && primes.get(i) < mitad; i++ ){
	            printy ( "Voy a analizar " + n + " con " + primes.get(i));
	            if ( n % primes.get(i) == 0 ){
	                printy( "Para " + n + " pongo al factor  " + primes.get(i));
	                if ( !factors.containsKey (primes.get(i)) ){
	                    factors.put(primes.get(i),1);
	                }
	                else {
	                    printy ( "Para " + n + " ya estaba el factor  " + primes.get(i));
	                    factors.put (primes.get(i), factors.get(primes.get(i))+1);
	                }
	                n = n/primes.get(i);
	                i = i - 1;
	            }
	        }
	        
	        if ( factors.size() == 0 ){ // n is prime.
	            factors.put (n,1);
	        }
	        
	        return factors;
		}
		


}
