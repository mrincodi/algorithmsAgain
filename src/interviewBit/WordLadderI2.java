package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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
 * Comment: with graphs.
 *
 */
public class WordLadderI2 {

	public int ladderLength(String start, String end, ArrayList<String> dictV) {

		Queue <String> q = new LinkedList <String> ();

		q.add(start);
		q.add(null);
		HashSet <String> stepped = new HashSet <String> ();
		int level = 1;
		if ( start.equals(end)) return 1;

		while (!q.isEmpty()){
			String s = q.remove();
			if ( s == null ){
				level++;
				q.add(null);
				continue;
			}

			if ( s.equals(end)) return level;

			stepped.add(s);

			//Now, find all the neighbors of this word.
			ArrayList<String> neighbors = findNeighbors (s,dictV,stepped);

			for (String neighbor:neighbors){
				q.add(neighbor);
			}

		}

		return level;
	}

	private ArrayList<String> findNeighbors(String s, ArrayList<String> dictV, HashSet<String> stepped) {
		ArrayList<String> result = new ArrayList<String> (0);
		for ( int i = 0; i < dictV.size(); i++){
			String thisWord=dictV.get(i);
			if (!stepped.contains(thisWord) && isNeighbor (s, thisWord)){
				result.add(thisWord);
			}
		}
		return result;
	}


	private boolean isNeighbor(String s, String thisWord) {
		int numDiff=0;
		if (s.length()!= thisWord.length()) return false;

		for ( int i = 0; i < s.length(); i++){			
			if (s.charAt(i) != thisWord.charAt(i)) numDiff++;
			if (numDiff > 1) return false;
		}
		return numDiff==1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String start = "baaaba";
		String end = "aabbbb";

		ArrayList<String> dictV = new ArrayList<String> ( Arrays.asList( "abbbbb","bbabba","abbaba","baaabb","bbbabb","babbab","aaabaa","aaabbb","bbbaab","aabaaa","aaaaaa","baaabb","aababa","aaabab","bbbaaa","aabaab","ababab","bbaaba","ababba","abaaab","baaaab","aababb","aaaaaa","abbbab","aaabab","bbabab","aaaabb","aaaaab","babaab","babbab","baaaba","aabbaa","aabbaa","bbabab","bbaaba","abbbbb","bbbbbb","babaab","baaaab","abaaab","abbaab","aaaaaa","bbbbba","babbba","bbbabb","abaaab","aabbba","baaaba","aabbbb"));
		int n = new WordLadderI2().ladderLength(start, end, dictV);
		System.out.println(n);
	}

}
