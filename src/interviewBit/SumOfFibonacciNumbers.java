package interviewBit;

import java.util.ArrayList;

public class SumOfFibonacciNumbers {

	public int fibsum(int a) {
		//Calculate fibonacci numbers smaller or equal than a.
		ArrayList <Integer> al = fibList ( a );

		int numdigits=0;
		int amount = 0;

		//Take the largest fibonacci number in the chain.
		//Should be the first one (I guess))

		amount = al.get(al.size()-1);
		numdigits=1;

		while (amount < a ){
			for ( int i = al.size()-1;i>=0;i--){
				int fibNum = al.get(i);
				boolean works = true;
				while (works){
					if (amount + al.get(i) <= a ){
						amount=amount + al.get(i);
						numdigits++;
					}
					else works = false;
				}
			}
		}
		return numdigits;
	}

	ArrayList <Integer> fibList ( int n ){

		ArrayList <Integer> al = new ArrayList <Integer> ();

		al.add(1);

		if ( n <=0 ) return al;

		al.add(1);

		if ( n == 1 ) return al;

		boolean overflow = false;

		int i=2;
		while (!overflow){
			int num = al.get(i-1)+al.get(i-2);

			if (num>n) overflow = true;
			else {
				al.add (num);
				i++;
			}
		}

		return al;
	}


	public static void main ( String [] args ) {

		int a =new SumOfFibonacciNumbers().fibsum(7);
		System.out.println(a);
	}

}
