package topcoder;

import java.util.Arrays;

public class ParenthesesAndPermutation1 {

	final String IMP = "Impossible";
	final char X='x';
	int howMany = 0;

	public String getSequence ( int [] p ){

		char [] s = new char [p.length];
		char [] t = new char [p.length];

		if ( p.length==0 ) return s.toString();
		if ( p.length % 2 != 0 ) return IMP;

		Arrays.fill(s, 'x');
		Arrays.fill(t, 'x');

		String result = getSequence (p,s,t);

		return result == null ? IMP : result;
	}
	private String getSequence(int[] p, char[] s, char[] t) {
		howMany++;

		if ( s[s.length-1]!= X){
			if ( isValid (s) && isValid (t)) return new String(s);
			else return null;
		}

		if ( !canBeValid (s) || !canBeValid (t)) return null;

		//TODO: This is the first position with an X, and could be a parameter.
		int pos = getPosition(s);	
		
		char [] sPlusOpen = new char[s.length];
		char [] sPlusClose = new char[s.length];
		char [] tPlusOpen = new char[s.length];
		char [] tPlusClose = new char[s.length];

		System.arraycopy(s, 0, sPlusOpen,  0, s.length);
		System.arraycopy(s, 0, sPlusClose, 0, s.length);
		System.arraycopy(t, 0, tPlusOpen,  0, s.length);
		System.arraycopy(t, 0, tPlusClose, 0, s.length);

		sPlusOpen [pos]='(';
		sPlusClose[pos]=')';
		tPlusOpen [p[pos]]='(';
		tPlusClose[p[pos]]=')';

		String resultWithOpen = getSequence (p, sPlusOpen, tPlusOpen);
		String resultWithClose= getSequence (p, sPlusClose, tPlusClose);

		if ( resultWithOpen != null ) return resultWithOpen;
		if ( resultWithClose != null ) return resultWithClose;

		return null;

	}

	private int getPosition(char[] s) {
		for ( int i =0;i<s.length;i++)
			if (s[i]==X) return i;
		return -1;
	}

	private boolean isValid(char[] s) {
		int val = 0;

		for ( char c : s){
			if (c=='(') val++;
			if (c==')') val--;
			if ( val < 0 ) return false;
		}

		return val==0?true:false;
	}

	//TODO: Enhance this one.
	public boolean canBeValid(char []s ){
		int countOpen = 0;
		for ( char c: s){
			if ( c=='(') countOpen++;
		}
		//if (countOpen>s.length/2) System.out.println("good");
		return countOpen>s.length/2?false:true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] p = { 17, 1, 19, 16, 13, 12, 2, 10, 7, 14, 9, 0, 18, 4, 5, 11, 8, 3, 6, 15 };
		ParenthesesAndPermutation1 pap = new ParenthesesAndPermutation1 ();
		String seq = pap.getSequence(p);
		System.out.println(seq);
		System.out.println(pap.howMany);
		
	}

}
