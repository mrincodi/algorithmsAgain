package interviewBit;

/**
 * GCD of 2 numbers.
 * 
 * Access Hint
Lets say g is gcd(m, n) and m > n.

m = g * m1
n = g * m2

m - n = g * (m1 - m2)

gcd (m, n) = gcd(m-n, n)

Can you use the above fact to find the gcd ?

Lets say g is gcd(m, n) and m > n.

m = g * m1
n = g * m2

m - n = g * (m1 - m2)

gcd (m, n) = gcd(m-n, n)

           = gcd(m - 2n, n) if m >= 2n
           = gcd(m - 3n, n) if m >= 3n 
             .
             .
             .
           = gcd(m - k*n, n) if m >= k*n
           
       In other words, we keep subtracting n till the result is greater than 0. Ultimately we will end up with m % n.
       
              So gcd(m, n)  = gcd(m % n, n) 


 * @author Mario
 *
 */
public class GCD {
	public int gcd(int a, int b) {

		//Let's make a the bigger one.
		if ( a < b ){
			int temp = a;
			a = b;
			b=temp;
		}

		if ( b == 0 ) return a;

		a = a % b;

		//if ( a == 0 ) return b;
		return gcd ( b, a );
	}
}
