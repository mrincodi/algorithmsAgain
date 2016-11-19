package algorithmsAgain;

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
 * Comment: I enhanced it a lot. Still not good enough for InterviewBit.
 * The DP solution is pretty cool.
 */
public class RegularExpressionMatch {

	public int isMatch(final String s, final String p) {

		String p2 = joinStars (p);

		return isMatch1(s,p2);
	}

	public int isMatch1( String s,  String p) {

		if ( p.length () == 0 ) {
			if ( s.length()==0 ) return 1;
			return 0;
		}

		boolean gottaExit = false;
		char regexChar = p.charAt(0);

		while (!gottaExit){
			if ( p.length() == 0) {
				if (s.length() == 0) return 1;
				else return 0;
			}
			if (s.length()==0){
				if (p.equals("*")) return 1;
				else return 0;
			}

			regexChar = p.charAt(0); 
			if (regexChar == '?'){
				if ( s.length()==0 ) return 0;
				s=s.substring(1);
				p=p.substring(1);
			}
			else if (regexChar != '*' ){
				if ( s.length()==0 || s.charAt(0) != p.charAt(0) ) return 0;
				s=s.substring(1);
				p=p.substring(1);
			}
			else {
				gottaExit=true;
			}

		}

		//At this moment the string p should be "*..."
		if ( p.equals("*"))return 1;

		String restRegex = p.substring(1);
		for ( int i = 0; i <= s.length(); i++ ){
			//System.out.println(s.substring(i) +"\t" + restRegex);
			
			if ( isMatch (s.substring(i),restRegex) == 1) return 1;
		}
		return 0;
	}

	private String joinStars(String p) {
		//TODO: Enhance with a StringBuffer.
		String p2 = "";
		if ( p.length()==0) return p;
		char prevChar = p.charAt(0);
		p2 = prevChar + "";
		for ( int i = 1; i< p.length(); i++){
			char c = p.charAt(i);
			if (!(c == prevChar && c == '*')){
				p2 = p2 + p.charAt(i);
			}
			prevChar=c;
		}
		return p2;
	}

	public static void main(String[] args) {
		String s =  "bacb";
		String p = "b**c*?*";
		
		s= "cbccbbbbaa";
		p= "*b*b*********b*a*a";
		//p= "?b*??b*aa";
		
		int r = new RegularExpressionMatch().isMatch(s, p);
		System.out.println(r);
	}

}
