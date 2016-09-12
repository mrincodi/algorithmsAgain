package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

You must change exactly one character in every transformation
Each intermediate word must exist in the dictionary
Example :

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note that we account for the length of the transformation path instead of the number of transformation itself.

 Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 * @author mrincodi
 * 2016-09-11
 * Comment: Yeah, I solved it, but this should have been solved with graphs and BFS.
 * Instead I used typical recursion and dynamic programming (say, "enhanced" DFS).
 * So I think I should solve this with graphs, properly.
 *
 */
public class WordLadderI {
	
	HashMap < HashSet <String>, Integer> already  = new HashMap < HashSet <String>, Integer> ();
	
	public int ladderLength(String start, String end, ArrayList<String> dictV) {

		HashSet<String> wordsBag = new HashSet<String>();
		
		wordsBag.add(start);

		int result = ladderLength( start, end, dictV, wordsBag);
		return result==-1?0:result;
	}

	private int ladderLength(String start, String end, ArrayList<String> dictV, HashSet<String> wordsSoFar) {

		if ( start.equals (end)) return 1;
		
		if (already.containsKey(wordsSoFar)) return already.get(wordsSoFar);

		//Get the neighbors.
		int length = Integer.MAX_VALUE;
		boolean atLeastOne = false;
		for ( int i = 0; i < dictV.size();i++){
			String word = dictV.get(i);
			if (isNeighbor(start,word) && !wordsSoFar.contains(word)){

				HashSet<String> wordsSoFarPlusOne = new HashSet <String>(wordsSoFar);
				ArrayList<String> dictVMinusOne = new ArrayList<String> (dictV);
				dictVMinusOne.remove(i);

				wordsSoFarPlusOne.add(word);
				int thisLength =  ladderLength (word,  end, dictVMinusOne, wordsSoFarPlusOne);
				if ( thisLength != -1 ){
					atLeastOne=true;
					thisLength++;
					length = Math.min (thisLength, length);
				}
			}
		}
		
		if ( !atLeastOne) length = -1;
		
		already.put(wordsSoFar, length);
		
		return length;
	}

	private Boolean isNeighbor (String a, String b){
		int howManyDiff = 0;
		for ( int i = 0; i < a.length(); i++ ){
			char c1 = a.charAt(i);
			char c2 = b.charAt(i);
			if ( c1 != c2) howManyDiff++;
		}

		return howManyDiff==1?true:false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String start = "baaaba";
		String end = "aabbbb";
		
		ArrayList<String> dictV = new ArrayList<String> ( Arrays.asList( "abbbbb","bbabba","abbaba","baaabb","bbbabb","babbab","aaabaa","aaabbb","bbbaab","aabaaa","aaaaaa","baaabb","aababa","aaabab","bbbaaa","aabaab","ababab","bbaaba","ababba","abaaab","baaaab","aababb","aaaaaa","abbbab","aaabab","bbabab","aaaabb","aaaaab","babaab","babbab","baaaba","aabbaa","aabbaa","bbabab","bbaaba","abbbbb","bbbbbb","babaab","baaaab","abaaab","abbaab","aaaaaa","bbbbba","babbba","bbbabb","abaaab","aabbba","baaaba","aabbbb"));
		int n = new WordLadderI().ladderLength(start, end, dictV);
		System.out.println(n);
	}

}
