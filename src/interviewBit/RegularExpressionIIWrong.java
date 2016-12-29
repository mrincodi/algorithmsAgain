package interviewBit;

/**
 * 
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:

int isMatch(const char *s, const char *p)
Some examples:

isMatch("aa","a") → 0
isMatch("aa","aa") → 1
isMatch("aaa","aa") → 0
isMatch("aa", "a*") → 1
isMatch("aa", ".*") → 1
isMatch("ab", ".*") → 1
isMatch("aab", "c*a*b") → 1
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 * @author mrincodi
 * 2016-12-12
 * Comment: Wrong. Note to self: Read the description and don't assume.
 */
public class RegularExpressionIIWrong {

	public int isMatch(final String s, final String regex) {

		if ( regex.length () == 0 )
			return s.length()==0?1:0;

		int sPointer = 0;
		for ( int regexPointer = 0; regexPointer < regex.length(); regexPointer++ ){
			char regexC = regex.charAt ( regexPointer );
			switch (regexC) {
			case '.':
				if (sPointer == s.length()) return 0;
				sPointer++;
				break;
			case '*':
				if (regexPointer == regex.length() - 1) return 1; //Matches the rest of the string.
				regexPointer++;
				String regex2 = regex.substring (regexPointer);
				for ( int startPoint = sPointer; sPointer < s.length(); sPointer++ ){
					int possibleMatch = isMatch (s.substring (startPoint), regex2);
					if ( possibleMatch == 1) return 1;
				}
				return 0;

			default:
				if (sPointer == s.length()) return 0;
				if (s.charAt(sPointer) != regex.charAt(regexPointer)) return 0;
				sPointer++;
				break;
			}
		}

		return sPointer==s.length()?1:0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
