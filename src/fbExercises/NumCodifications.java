package fbExercises;

public class NumCodifications {

	public int numCodifications ( int [] digits ){
		int result = 0;
		if ( digits.length == 0 ) return 0;

		//numCodXMinus2 = number of codifications from position (X-2) in the array of digits. 
		int numCodXMinus2 = digits[digits.length - 1]==0?0:1;

		if ( digits.length == 1 ) return numCodXMinus2;

		//numCodXMinus1 = number of codifications from position (X-1) in the array of digits. 
		int numCodXMinus1 = 0;

		if ( digits[digits.length - 2] != 0 ){
			if ( digits[digits.length - 1] == 0 ){
				if ( digits[digits.length - 2] <=2 )
					numCodXMinus1 = 1;
				else
					numCodXMinus1 = 0;
			}
			else {
				numCodXMinus1 = 1;
				if ( digits[digits.length - 2] * 10 + digits[digits.length - 1 ]<= 26 )
					numCodXMinus1 = 2;
			}
		}
		if ( digits.length == 2 ) return numCodXMinus1;

		for ( int i = digits.length - 3; i >= 0; i-- ){
			int digit = digits[i];
			if ( digit == 0 ){
				result=0;
			}
			else {
				result = numCodXMinus1;
				if ( digit * 10 + digits [ i + 1] <= 26 )
					result += numCodXMinus2;
			}
			numCodXMinus2=numCodXMinus1;
			numCodXMinus1=result;

		}
		return result;
	}

	public static void main(String[] args) {
		//Funny fact: try with arrays of only 1's (or 2's). You'll notice a pattern. 
		int [] digits = {1,1,1,4,4,1,0,1,1,1};
		int numCod = new NumCodifications().numCodifications(digits);
		System.out.println(numCod);
	}

}
