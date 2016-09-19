package algorithmsAgain;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer. 
For example, 
given strings "12", "10", your answer should be “120”.

NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ). 
We will retroactively disqualify such submissions and the submissions will incur penalties.
 * 
 * @author mrincodi
 * 2016-09-17
 * Comment: Ugh.
 *
 *
 */
public class MultiplyStrings {

	public String multiply(String a, String b) {
		if ( a.equals("0") || b.equals("0")) return "0";
		//Remove trailing zeroes (tsk, tsk).
		int trailingZeroes = 0;
		for ( int i = 0; i < a.length(); i++){
			if ( a.charAt(i) != '0' ) break;
			else trailingZeroes++;
		}
		a = a.substring(trailingZeroes);
		
		trailingZeroes = 0;
		for ( int i = 0; i < b.length(); i++){
			if ( b.charAt(i) != '0' ) break;
			else trailingZeroes++;
		}
		b = b.substring(trailingZeroes);
		
		if ( a.length() == 0 || b.length() == 0) return "0";
		
		String result = "";
		String prevResult = "";
		for ( int bp = b.length () - 1; bp >= 0; bp-- ){
			int bDigit = Integer.parseInt (b.charAt(bp) + "");
			int resultCarry = 0;

			for ( int i = b.length () -1; i > bp; i--){
				result = result + "0";
			}

			for ( int ap = a.length()-1; ap >=0; ap--){
				int aDigit = Integer.parseInt (a.charAt(ap) + "");
				int resultInt = ( aDigit * bDigit ) + resultCarry;
				int resultDigit = resultInt % 10;
				resultCarry = resultInt / 10;

				result = resultDigit + result;  // May be 0.
			}
			if ( resultCarry != 0) result = resultCarry + result;

			//Now, add this result to the previous one.
			if (bp == b.length () - 1) prevResult = result;
			else {
				String totalResult = addStrings (result, prevResult);
				prevResult = totalResult;
			}
			result="";
		}
		return prevResult;

	}

	public String addStrings ( String result, String prevResult){
		//Only result may be larger than prevResult, up to two numbers.
		String finalResult = "";
		int carryInt = 0;
		for (int i = 0 ; i < prevResult.length() ; i++){
			int posPrevResult = prevResult.length() - i - 1;
			int posResult = result.length() - i - 1;
			int digit1 = Integer.parseInt ( result.charAt(posResult) + "" );
			int digit2 = Integer.parseInt ( prevResult.charAt(posPrevResult) + "");

			int resultInt =  digit1 + digit2 + carryInt;
			int resultDigit = resultInt % 10;
			carryInt = resultInt / 10;

			finalResult = resultDigit + finalResult;
		}

		if ( result.length () == prevResult.length ()){
			if (carryInt != 0) finalResult = carryInt + finalResult;
		}
		else if ( result.length () == prevResult.length () + 1){
			int digit1 = Integer.parseInt ( result.charAt(0) + "");
			int resultInt =  digit1 + carryInt;
			int resultDigit = resultInt % 10;
			int resultCarry = resultInt / 10;

			finalResult = resultDigit + finalResult;

			//This should not happen.
			if ( resultCarry != 0) finalResult = resultCarry + finalResult;
		}
		else if ( result.length () == prevResult.length () + 2){
			int digit1 = Integer.parseInt ( result.charAt(1) + "" );
			int resultInt =  digit1 + carryInt;
			int resultDigit = resultInt % 10;
			int resultCarry = resultInt / 10;

			finalResult = resultDigit + finalResult;

			digit1 =  Integer.parseInt ( result.charAt(0) + "");
			resultDigit = digit1 + resultCarry;
			//This should not be greater than 9.
			finalResult = resultDigit + finalResult;
		}
		return finalResult;
	}

	public static void main(String[] args) {
		String a = "99999";
		String b = "078";

		String c = new MultiplyStrings().multiply(a, b);
		System.out.println(c);
	}

}
