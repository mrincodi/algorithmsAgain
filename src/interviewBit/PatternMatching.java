package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PatternMatching {

	ArrayList <String> matchPattern ( String pattern, ArrayList <String>  dict){
		ArrayList <String> result = new ArrayList <String> ();
		for ( String word: dict ){
			if ( word.length()==pattern.length()){
				HashMap <Character, Character > match = new HashMap <Character, Character > ();
				boolean possiblyValid=true;
				for ( int i = 0; i < word.length() && possiblyValid; i++ ){
					
					char patternC = pattern.charAt(i);
					char c = word.charAt(i);
					if ( match.containsKey(c)){
						if ( match.get(c)!= patternC)
							possiblyValid=false;
					}
					else
						match.put(c,patternC);
				}
				if (possiblyValid) result.add(word);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String pattern = "abc";
		ArrayList <String>  dict = new ArrayList <String> (Arrays.asList("cdf", "too", "hgfdt" ,"paa", "xyz"));

		ArrayList <String> matches = new PatternMatching().matchPattern(pattern, dict);
		
		for (String s:matches)
			System.out.println(s);
	}
}
