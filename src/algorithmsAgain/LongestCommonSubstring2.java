package algorithmsAgain;

import java.util.Arrays;

/**
 * Longest common substring, not contiguous.
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH”.
 * 
 * @author mrincodi
 * 2016-08-31
 * Comment: DP, the matrix approach, the "right" way.
 */
public class LongestCommonSubstring2 {


	String lcs (String a, String b){
		String result = "";
		if (a == null || b == null ) return null;
		if (a.length() == 0 || b.length () == 0) return result;

		if ( a.equals(b) ) return a;

		String [][] matrix = new String [a.length()][b.length()];

		//Let's initialize the matrix.
		char c = b.charAt(0);
		boolean bb = false;
		for ( int i=0;i<a.length();i++){
			if ( bb ) matrix[i][0]=c+"";
			else if ( a.charAt(i)==c){
				bb=true;
				matrix[i][0]=c+"";
			}
			else matrix[i][0]="";
		}
		
		c = a.charAt(0);
		bb = false;
		for ( int i=0;i<b.length();i++){
			if ( bb ) matrix[0][i]=c+"";
			else if ( b.charAt(i)==c){
				bb=true;
				matrix[0][i]=c+"";
			}
			else matrix[0][i]="";
		}

		for ( int aPtr = 1; aPtr < a. length(); aPtr++){
			for ( int bPtr = 1; bPtr < b. length(); bPtr++){
				if ( a.charAt(aPtr) == b.charAt(bPtr) )
					matrix[aPtr][bPtr]=matrix[aPtr-1][bPtr-1]+a.charAt(aPtr);
				else{
					String prev = matrix[aPtr][bPtr-1];
					String poss = matrix[aPtr-1][bPtr];
					matrix[aPtr][bPtr]=poss.length()>prev.length()?poss:prev;
				}
			}
		}

		return matrix [a.length()-1][b.length()-1];
	}

	public static void main(String[] args) {
		String a = "sdafasfsdfsdferrgrmijig";
		String b = "ngujyoimoihririisanioniunouhdiuhfiouhiusd";

		String c = new LongestCommonSubstring2().lcs(a, b);

		System.out.println(c);


	}

}
