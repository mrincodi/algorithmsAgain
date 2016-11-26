package interviewBit;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' : Matches any single character.
'*' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

The function prototype should be:

int isMatch(const char *s, const char *p)
Examples :

isMatch("aa","a") → 0
isMatch("aa","aa") → 1
isMatch("aaa","aa") → 0
isMatch("aa", "*") → 1
isMatch("aa", "a*") → 1
isMatch("ab", "?*") → 1
isMatch("aab", "c*a*b") → 0
Return 1/0 for this problem.

 * @author mrincodi
 * 2016-11-18
 * Comment: Nice problem. This solution doesn't work for long inputs.
 */
public class RegularExpressionMatch1 {

	public int isMatch(final String s, final String p) {
	    if ( p.length () == 0 ) {
	        if ( s.length()==0 ) return 1;
	        return 0;
	    } 
	    char regexChar = p.charAt(0);
	    String restRegex = p.substring(1);
	    
	    switch ( regexChar ){
	        case '?':
	            if (s.length() == 0) return 0;
	            return isMatch (s.substring(1), restRegex);
	            //break;
	            
	        case '*':
	            if ( s.length()==0) return isMatch (s, restRegex);
	            for ( int i = 0; i <= s.length(); i++ ){
	                if ( isMatch (s.substring(i),restRegex) == 1) return 1;
	            }
	            return 0;
	            //break;
	        
	        default:
	            if (s.length() == 0 || regexChar != s.charAt(0) ) return 0;
	            return isMatch (s.substring(1), restRegex);
	            //break;
	    }
	    //return 0;
	}

	public static void main(String[] args) {
		String s =  "bacb";
		String p = "b**c*?*";
//		s="acb";
//		p="*cb";
		int r = new RegularExpressionMatch1().isMatch(s, p);
		System.out.println(r);
	}

}
