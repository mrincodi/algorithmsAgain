package interviewBit;

import java.util.Arrays;

/**
 * Longest common substring, not contiguous.
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH”.
 * 
 * @author mrincodi
 * 2016-08-31
 * Comment: DP!! I just did this one because I think the solution is awesome.
 */
public class LongestCommonSubstring {
	
	java.util.HashMap <java.util.ArrayList<String>,String> dp = new 
			java.util.HashMap <java.util.ArrayList<String>,String> ();
	
	String lcs (String a, String b){
//		System.out.println( a + "   " +  b);
		
		if ( a==null || b == null || a.length ()==0 || b.length()==0) return "";
		if (dp.containsKey(new java.util.ArrayList<String>(Arrays.asList(a,b)))){
//			System.out.print("!");
			return dp.get(new java.util.ArrayList<String>(Arrays.asList(a,b)));
		}
				
		char lastCharA = a.charAt(a.length() -1);
		char lastCharB = b.charAt(b.length() -1);
		
		String subA = a.substring(0,a.length()-1);
		String subB = b.substring(0,b.length()-1);
		
		if ( lastCharA == lastCharB)
			return lcs (subA, subB) + lastCharA;
		else {
			String solutionX = lcs (subA, b);
			String solutionY = lcs (a, subB);
			
			String solution = "";
			if ( solutionX.length() > solutionY.length()) solution = solutionX;
			else solution = solutionY;
			
			dp.put(new java.util.ArrayList<String>(Arrays.asList(a,b)), solution);
			return solution;
		}
	}

	public static void main(String[] args) {
		String a = "sdafasfsdfsdferrgrmijig";
		String b = "ngujyoimoihririisanioniunouhdiuhfiouhiusd";
		
		String c = new LongestCommonSubstring().lcs(a, b);
		
		System.out.println(c);
		

	}

}
