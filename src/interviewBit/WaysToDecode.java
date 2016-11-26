package interviewBit;

import java.util.HashMap;


/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

Example :

Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 * @author mrincodi
 * 2016-08-10
 * Comment: Easy. A bit tricky. My solution uses a hashMap from String to int, and
 * I always query the remaining string.
 * InterviewBit's uses an array to save the value at each position. I think their
 * solution is more elegant.
 */
public class WaysToDecode {


	HashMap <String, Integer> h = new HashMap <String, Integer> ();

	public int numDecodings(String a) {
		if ( a == null || a.length () == 0 ) return 0;

		if ( h.containsKey(a) ) return h.get(a);

		//Take the first number.
		int number = 0;

		int digit1 = Integer.parseInt (a.charAt(0) + "");
		int digit2 = -1;
		String shorterWord = "";

		if ( digit1 == 0 ) return 0;

		if ( a.length () == 1 ) return 1;

		if (a.length() >=2) digit2 =  Integer.parseInt (a.charAt(1) + "");

		if ( a.length () == 2 && digit1 <= 2 && digit2 >0 && digit2 <= 6 ) return 2;

		if ( a.length () == 2 && digit2 == 0 ) return 1;

		if (digit1 > 2 ){
			shorterWord = a.substring (1, a.length());
			number = numDecodings (shorterWord);
			h.put (shorterWord, number);
			return number;
		}

		if (digit1 == 2 && digit2 > 6){
			shorterWord = a.substring (1, a.length());
			number = numDecodings (shorterWord);
			h.put (shorterWord, number);
			return number;
		}

		int number2 = 0;

		shorterWord = a.substring (1, a.length());
		number = numDecodings (shorterWord);
		h.put (shorterWord, number);

		shorterWord = a.substring (2, a.length());
		number2 = numDecodings (shorterWord);
		h.put (shorterWord, number2);

		return number + number2;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
