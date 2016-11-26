package interviewBit;

/**
 * 
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Read more details about roman numerals at Roman Numeric System

Example :

Input : "XIV"
Return : 14
Input : "XX"
Output : 20
 * @author mrincodi
 * 2016-10-03
 * Comment: Cute. Compare with IntegerToRoman.
 *
 */
public class RomanToInteger {

	public int romanToInt(String a) {
		int result = 0;
		if ( a == null || a.length () == 0) return 0;

		int pointer = 0;

		while (pointer != a.length ()){
			char c = a.charAt(pointer);

			switch (c){
			case 'M':
				result += 1000;
				break;

			case 'D':
				result += 500;
				break;

			case 'C':
				if      ( pointer != a.length () -1 && a.charAt(pointer + 1) == 'M' ){
					result +=900;
					pointer++;
				}
				else if ( pointer != a.length () -1 && a.charAt(pointer + 1) == 'D' ){
					result += 400;
					pointer++;
				}
				else
					result+=100;
				break;

			case 'L':
				result += 50;
				break;

			case 'X':
				if      ( pointer != a.length () -1 && a.charAt(pointer + 1) == 'C' ){
					result +=90;
					pointer++;
				}
				else if ( pointer != a.length () -1 && a.charAt(pointer + 1) == 'L' ){
					result += 40;
					pointer++;
				}
				else
					result+=10;
				break;

			case 'V':
				result +=5;
				break;

			case 'I':
				if      ( pointer != a.length () -1 && a.charAt(pointer + 1) == 'X' ){
					result +=9;
					pointer++;
				}
				else if ( pointer != a.length () -1 && a.charAt(pointer + 1) == 'V' ){
					result += 4;
					pointer++;
				}
				else
					result+=1;
				break;
			}
			pointer++;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
