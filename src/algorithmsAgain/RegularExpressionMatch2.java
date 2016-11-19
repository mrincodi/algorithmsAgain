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
 * Comment: InterviewBit's DP solution.
 */
public class RegularExpressionMatch2 {
		public int isMatch(final String s, final String p) {
		    boolean[][] d = new boolean[s.length() + 1][p.length() + 1];
		    d[0][0] = true;
		    if (p.charAt(0) == '*') {
		        d[0][1] = true;
		    }
		    for (int i = 0; i < p.length(); ++i) {
		        if (p.charAt(i) == '*') {
		            d[0][i + 1] = d[0][i];
		            for (int j = 0; j < s.length(); ++j) {
		                d[j + 1][i + 1] = d[j][i] || d[j + 1][i] || d[j][i + 1];
		            }
		        } else if (p.charAt(i) == '?') {
		            for (int j = s.length() - 1; j >= 0; --j) {
		                d[j + 1][i + 1] = d[j][i];
		            }
		        } else {
		            for (int j = 0; j < s.length(); ++j) {
		                if (p.charAt(i) == s.charAt(j)) {
		                    d[j + 1][i + 1] = d[j][i];
		                }
		            }
		        }
		    }
		    return d[s.length()][p.length()] ? 1 : 0;
		}

	public static void main(String[] args) {
		String s =  "bacb";
		String p = "b**c*?*";
		
		s= "cbccbbbbaa";
		p= "*b*b*********b*a*a";
		//p= "?b*??b*aa";
		
		int r = new RegularExpressionMatch2().isMatch(s, p);
		System.out.println(r);
	}

}
