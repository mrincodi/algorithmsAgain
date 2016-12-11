package interviewBit;

/**
 * 
Please Note:

Another question which belongs to the category of questions which are intentionally stated vaguely. 
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

Input is guaranteed to be within the range from 1 to 3999.

Example :

Input : 5
Return : "V"

Input : 14
Return : "XIV"
 Note : This question has a lot of scope of clarification from the interviewer. Please take a moment to think of all 
 the needed clarifications and see the expected response using �See Expected Output� For the purpose of this question, 
 https://projecteuler.net/about=roman_numerals has very detailed explanations. 
 
 
 * @author mrincodi
 *
 */
public class IntegerToRoman {

	public String intToRoman(int a) {

		StringBuffer s = new StringBuffer ();
		//Take every digit.
		int d=0;

		d = a / 1000;

		if ( d > 0 ){
			switch (d){
			case 1:s.append("M");   break;
			case 2:s.append("MM");  break;
			case 3:s.append("MMM"); break;
			}
		}

		d = a / 100 % 10;
		if ( d > 0 ){
			switch (d){
			case 1:s.append("C");   break;
			case 2:s.append("CC");  break;
			case 3:s.append("CCC"); break;
			case 4:s.append("CD"); break;
			case 5:s.append("D"); break;
			case 6:s.append("DC"); break;
			case 7:s.append("DCC"); break;
			case 8:s.append("DCCC"); break;
			case 9:s.append("CM"); break;
			}
		}

		d = a / 10 % 10;
		if ( d > 0 ){
			switch (d){
			case 1:s.append("X");   break;
			case 2:s.append("XX");  break;
			case 3:s.append("XXX"); break;
			case 4:s.append("XL"); break;
			case 5:s.append("L"); break;
			case 6:s.append("LX"); break;
			case 7:s.append("LXX"); break;
			case 8:s.append("LXXX"); break;
			case 9:s.append("XC"); break;
			}
		}

		d = a % 10;
		if ( d > 0 ){
			switch (d){
			case 1:s.append("I");   break;
			case 2:s.append("II");  break;
			case 3:s.append("III"); break;
			case 4:s.append("IV"); break;
			case 5:s.append("V"); break;
			case 6:s.append("VI"); break;
			case 7:s.append("VII"); break;
			case 8:s.append("VIII"); break;
			case 9:s.append("IX"); break;
			}
		}

		return s.toString ();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
