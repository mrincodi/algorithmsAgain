package topcoder;

/**
 * 
 * 
 * 
Problem Statement
Correct parentheses sequences can be defined recursively as follows:
The empty string "" is a correct sequence.
If "X" and "Y" are correct sequences, then "XY" (the concatenation of X and Y) is a correct sequence.
If "X" is a correct sequence, then "(X)" is a correct sequence.
Each correct parentheses sequence can be derived using the above rules.
Examples of correct parentheses sequences include "", "()", "()()()", "(()())", and "(((())))".

You are given a p with n elements. The elements of p are a permutation of the numbers 0 to n-1. Find strings s and t with the following properties:
Both s and t are correct parentheses sequences.
Each of them has exactly n characters.
For each valid i, s[i] = t[ p[i] ].

Return one possible string s. If there are multiple possibilities, you may return any of them. If there is no solution, return "Impossible" instead.
Definition
Class: ParenthesesAndPermutation
Method: getSequence
Parameters: int[]
Returns: String
Method signature: String getSequence(int[] p)
(be sure your method is public)
Limits
Time limit (s): 2.000
Memory limit (MB): 256
Constraints
- p will contain between 2 and 50 elements, inclusive.
- The length of p will be even.
- p will be a permutation of 0 to (|p|-1).
Examples
0)
{2,0,3,1}
Returns: "(())"
We are looking for two correct parentheses sequences such that s[0]=t[2], s[1]=t[0], s[2]=t[3], and s[3]=t[1]. 

There are two parentheses sequences of length 4: "(())" and "()()". We can now argue as follows:
Can s be "(())"? We can deduce that t must be "()()" which is a correct parentheses sequence, so this is a valid solution.
Can s be "()()"? We can deduce that t must be "))((" which is not a correct parentheses sequence, so this is not a valid solution.

Therefore, the only valid solution is s = "(())".
1)
{1,0}
Returns: "Impossible"
s and t must each be "()", but then s[0] != t[p[0]], so it is impossible to find such s and t.
2)
{4,5,6,7,0,1,2,3}
Returns: "(())(())"
Another valid solution is: s = t = "()()()()".
3)
{9,8,7,6,5,4,3,2,1,0}
Returns: "Impossible"
4)
{0,1}
Returns: "()"

 * @author mrincodi
 * 2016-08-27
 * Comment: Beautiful problem! I gave it a SUPER enhancement when I swapped the 
 * positions of resultWithClose and resultWithOpen (see lines 115 to 119).
 * Also I am working with Strings instead of arrays.
 * For some reason this entry doesn't pass the system tests.
 *
 */
public class ParenthesesAndPermutation {

	final String IMP = "Impossible";
	final char X='x';
	//int howMany = 0;

	public String getSequence ( int [] p ){

		String s = "";
		String t = "";

		if ( p.length==0 ) return s;
		if ( p.length % 2 != 0 ) return IMP;

		StringBuffer sb = new StringBuffer ();
		for ( int i: p)
			sb.append("x");

		s=sb.toString();
		t=sb.toString();

		String result = getSequence (p,s,t,0);

		return result == null ? IMP : result;
	}
	private String getSequence(int[] p, String s, String t, int pos) {
		//System.out.println (t);
		//howMany++;
		if ( s.charAt(s.length()-1)!= X){
			if ( isValid (s) && isValid (t)) return new String(s);
			else return null;
		}

		if ( !canBeValid (s) || !canBeValid (t)) return null;

		//TODO: This is the first position with an X, and could be a parameter.
		//int pos = getPosition(s);	

		String sPlusOpen  = new String(s);
		String sPlusClose = new String(s);
		String tPlusOpen  = new String(t);
		String tPlusClose = new String(t);

		sPlusOpen  = sPlusOpen.substring(0,pos) + '(' + sPlusOpen.substring(pos+1);
		sPlusClose = sPlusOpen.substring(0,pos) + ')' + sPlusOpen.substring(pos+1);
		tPlusOpen  = tPlusOpen.substring(0,p[pos]) + '(' + tPlusOpen.substring(p[pos]+1);
		tPlusClose = tPlusOpen.substring(0,p[pos]) + ')' + tPlusOpen.substring(p[pos]+1);

		String resultWithClose= getSequence (p, sPlusClose, tPlusClose,pos+1);
		if ( resultWithClose != null ) return resultWithClose;
		
		String resultWithOpen = getSequence (p, sPlusOpen, tPlusOpen,pos+1);
		if ( resultWithOpen != null ) return resultWithOpen;

		return null;

	}

//	private int getPosition(String s) {
//		for ( int i =0;i<s.length();i++)
//			if (s.charAt(i)==X) return i;
//		return -1;
//	}

	private boolean isValid(String s) {
		int val = 0;

		for ( int i = 0; i < s.length();i++){
			char c = s.charAt(i);
			if (c=='(') val++;
			if (c==')') val--;
			if ( val < 0 ) return false;
		}

		return val==0?true:false;
	}

	//TODO: Enhance this one.
	public boolean canBeValid(String s ){
		int countOpen = 0;
		int countPossible = 0;

		for ( int i = 0; i < s.length();i++){
			char c = s.charAt(i);
			if ( c=='(' ) countOpen++;
			if ( c=='(' || c == X) 
				countPossible++;
			else 
				countPossible--;
			if (countPossible < 0 ) {
				//System.out.println("Good!");
				return false;
			}
		}
		//if (countOpen>s.length/2) System.out.println("good");
		return countOpen>s.length()/2?false:true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int [] p = {3,2,1,0};
		int [] p = { 28, 11, 7, 48, 31, 44, 26, 9, 46, 19, 8, 30, 14, 39, 24, 42, 4, 25, 27, 37, 16, 15, 45, 12, 10, 34, 20, 38, 40, 43, 0, 33, 49, 3, 35, 18, 41, 29, 2, 17, 1, 5, 47, 23, 36, 21, 6, 22, 13, 32};
		
		//int []  p = {85, 23, 33, 64, 27, 52, 31, 70, 88, 51, 43, 30, 29, 32, 47, 12, 62, 48, 74, 56, 96, 19, 81, 9, 84, 0, 42, 13, 8, 77, 79, 24, 5, 45, 86, 46, 75, 7, 1, 68, 72, 94, 4, 66, 90, 95, 14, 3, 93, 6, 98, 49, 71, 87, 91, 41, 22, 58, 73, 92, 34, 10, 21, 89, 17, 50, 39, 63, 25, 36, 99, 57, 18, 11, 37, 15, 38, 26, 53, 82, 54, 60, 80, 97, 35, 76, 78, 67, 28, 83, 65, 20, 61, 40, 2, 44, 69, 55, 59, 16};
		//	int [] p = {0,1,2,3};
		ParenthesesAndPermutation pap = new ParenthesesAndPermutation();
		String seq = pap.getSequence(p);

		System.out.println(seq);
		//System.out.println(pap.howMany);
	}

}
