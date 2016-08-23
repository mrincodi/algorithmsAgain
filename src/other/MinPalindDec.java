package other;

import java.util.ArrayList;

public class MinPalindDec {

	ArrayList <String> minPalindromicDecomposition ( String s ){
		ArrayList <String> result = new ArrayList <String> ();

		int minSizeFound = -1;

		if ( isPalindrome (s) ) {result.add (s);return result;}

		for ( int i = 1; i < s.length() ; i++ ){
			String initialWord = s.substring (0,i) ;
			if ( isPalindrome ( initialWord )){
				ArrayList<String> decompositionOfRest = minPalindromicDecomposition (s.substring ( i, s.length ()));

				int thisPartitionSize = decompositionOfRest.size();
				if ( minSizeFound == -1  ||  thisPartitionSize < minSizeFound ){
					minSizeFound = thisPartitionSize;
					decompositionOfRest.add(0,initialWord);
					result = decompositionOfRest;
				}
			}
		}

		return result;
	}

	boolean isPalindrome (String s ){
		if (s.length () <=1 ) return true;
		for ( int i = 0 ; i < s.length () -1 ; i++ ){
			if ( s.charAt(i) != s.charAt (s.length () - 1 - i )) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String a = "aaaaaaaaba";
		ArrayList <String> mpd = new MinPalindDec().minPalindromicDecomposition (a);
		for (String s: mpd){
			System.out.println (s);
		}
	}

}
