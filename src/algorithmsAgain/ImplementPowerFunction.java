package algorithmsAgain;
/**
 * Implement pow(x, n) % d.

In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative. 
In other words, make sure the answer you return is non negative.

I had to look at the solutions for this one, because I din't know that...
1) (A * B) mod C = (A mod C * B mod C) mod C
2) To find −b modN, just keep adding N to −b until the number is between 0 and N.
 * @author Mario
 *
 */

public class ImplementPowerFunction {
	public int pow(int x, int n, int d) {
	    
	    long a = x;
	    long res = 1L;
	    
	    while (n > 0) {
	        
	        if (n % 2 == 1) {
	            res *= a;
	            res %= d;
	        }
	        
	        a *= a;
	        a %= d;
	        n = n >> 1;
	        
	    }
	    
	    res = (res + d) % d;
	    
	    return (int) res;
	    
	}
}




/**
 *
public class ImplementPowerFunction {


		public int pow(int x, int n, int d) {
		    
		    //if ( n == 0 ) return 1;
		    
		    long val = 1;
		    
	        if ( n == 1 ) val = (long) x;
	        else {
	            //Let's calculate x ^n in a faster way.
	            val = (long) x;
	            int zn = 1;
	            for ( ; zn * 2 <= n ; zn = zn*2 ){
	                val=val*val;
	                System.out.println ("Tengo que zn es " + zn + " y val es " + val);
	            }
	            

	            System.out.println ("Ahora de " + zn + " a " + n );
	            for ( int i = zn; i < n; i++){
		            val = val * (long) x;
		            System.out.println ("Y voy por "+ val );
		        }
	            System.out.println ("Mi val es " +  val );

		        
	        }
	        
		    if ( val < 0 ){
		        //Keep adding d to val until the answer is positive.
		        while ( val < 0 ){
		            val += (long) d;
		        }
		        return (int) val;
		    }

//		    System.out.println ( "val = " + val);
		    long ratio = val / (long) d;
//		    System.out.println ( "/ " + d + " = " + ratio);

		    long diff = val - ( ratio * (long) d );
		    
		    return (int) diff;
		}

}
*/
