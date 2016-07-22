package algorithmsAgain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyBiggest {

	public String largestNumber(final List<Integer> a) {

		//		for ( int i = 0; i < a.size(); i++){
		//			System.out.println(a.get(i));
		//		}

		String result ="";

		//Let's make a new array of newString based on this.
		newString [] newArray = new newString [a.size()];

		for ( int i = 0; i < a.size(); i++){
			newArray [ i ] = new newString ( String.valueOf(a.get(i)));
		}

		//		for ( int i = 0; i < a.size(); i++){
		//			System.out.println(newArray [ i ].value);
		//		}

		java.util.Arrays.sort(newArray);

		for ( int i = newArray.length - 1; i>=0; i--){
			result += newArray[i].value;
		}

		if ( result.charAt(0) == '0') return "0"; 

		return result;
	}

	class newString implements java.lang.Comparable<newString>{

		String value;

		public newString (String  value){
			this.value=value;
		}

		public int compareTo (newString otro){

			//return this.value.compareTo(otro.value);
			//			//Get the two numeric values.
			String option1 = this.value + otro.value;
			String option2 = otro.value + this.value;

			BigInteger option1N = new BigInteger (option1);
			BigInteger option2N = new BigInteger (option2);

			//			return this.value.compareTo(otro.value);

			return ( option1N.compareTo(option2N) );
		}

	}

	public static void main ( String [] args ){
		ArrayList <Integer> theList = new ArrayList <Integer> ();
		Integer [] values = {5, 3, 30, 34, 5 ,9 };
		theList.addAll(Arrays.asList(values));

		MyBiggest mb = new MyBiggest ();
		String result = mb.largestNumber (theList);

		System.out.println( result);
	}


}
