package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
 * Comment: With graphs and BFS! Very interesting use of a "-1" value to differentiate between levels.
 * If I couldn't use that value for whatever reason, I think this could have been managed
 * with a HashMap: value -> level it belongs in the BFS. We wouldn't need the "already" array if we used
 * a hashmap this way.
 *
 */
public class WordLadderIWithGraphs {

	public int ladderLength(String start, String end, ArrayList<String> dictV) {

		//First, move the structure into a graph. Then, we'll do a BFS.

		if (!dictV.contains(start)) dictV.add(start);
		if (!dictV.contains(end)) dictV.add(end);

		int indexStart = dictV.indexOf(start);
		int indexEnd = dictV.indexOf(end);

		int n = dictV.size();
		int [][] neighbors = new int [n][n];

		for ( int i = 0; i < n; i++){
			for ( int j = 0; j < n; j++){
				if (areNeighbors (dictV.get(i),dictV.get(j)))
					neighbors[i][j]=1;
			}
		}
		
		//Now, BFS!
		Queue <Integer> q=new LinkedList <Integer> ();
		q.add(indexStart);
		q.add(-1);		// This will be the indicator of new levels!
		int level = 1;
		int [] already = new int [n];
		
		qqq:
		while (!q.isEmpty()){
			int node = q.remove();
			if ( node == indexEnd ) return level;
			if (node != -1){
				if ( already [ node ] == 1) continue qqq;
				//Get all the neighbors!
				already [ node ] = 1;
				for ( int i = 0; i < n; i++){
					if ( neighbors[node][i] == 1 ) q.add(i); 
				}
			}
			if (node == -1&&!q.isEmpty()){
				level++;
				q.add(-1);
			}
		}

		return 0;
	}


	private boolean areNeighbors(String a, String b) {
		int numdiff = 0;
		for ( int i = 0; i < a.length(); i++){
			if ( a.charAt(i)!= b.charAt(i)) numdiff++;
			if ( numdiff > 1) return false;
		}
		return numdiff==1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String start = "baaaba";
		String end = "aabbbb";

		//ArrayList<String> dictV = new ArrayList<String> ( Arrays.asList( "abbbbb","bbabba","abbaba","baaabb","bbbabb","babbab","aaabaa","aaabbb","bbbaab","aabaaa","aaaaaa","baaabb","aababa","aaabab","bbbaaa","aabaab","ababab","bbaaba","ababba","abaaab","baaaab","aababb","aaaaaa","abbbab","aaabab","bbabab","aaaabb","aaaaab","babaab","babbab","baaaba","aabbaa","aabbaa","bbabab","bbaaba","abbbbb","bbbbbb","babaab","baaaab","abaaab","abbaab","aaaaaa","bbbbba","babbba","bbbabb","abaaab","aabbba","baaaba","aabbbb"));


		ArrayList<String> dictV = new ArrayList<String> ( Arrays.asList( "aaababaaabbaabbbaaaaabbaaabaababbbbabbaaaaabbb","babbbaabbbbbabaaaabbaabbbaabbabbbaababbaabbbba","aaaaaaaabbbaababbbbbbbbababbbbbaaabaaababbaaba","abaabbaaabbbbbaabaaababababbabbabbbbbbabaababb","babbbabaaaababbbabbbabaabbbaababaabaabaabbabbb","baabbaaabaabbaabbbbbbbaabbabbaaabaaabbabbbbbaa","baaabbabbbbaaabaabbbbabbbaabbaaabaabbabbaabaab","bbabbaaaaaabaabbabbbabaaaabbbbaabababaabbaabba","bbabbabbbbbbbabbaabaaabaaabbaaaaaaaaabbabbaaab","baaabbaababbabaaaaaabaaabaaaabaabbbaaabbbbabba","babbbaaaabbaabaaaaabaaabbabaabaabaaaabababaaaa","aabbabaabaaababaabbbbbbaaabaaaaabbaaaaabaaaaba","abbbabbabaabbabbbabaababaaaabaaabaaaaaabbbaaaa","aaaababaaaababaaabbabaabaabaabaababbbabbbaaaab","abbbabaaabaababbbbbaaaaabbbbbbaabbababbbabbbaa","aabbbabbbabaaaaabaaaabaaaabaabbbbabbbaaaaaaaaa","abbabbaababbbaaaaabaaabbbbaaaabbbbbaabbaaababa","baaaaaabaaaaabaabaaabababaaabaaaaaaababbabbbbb","bbaabaabaababababbbbbbabbabbbbbbbbabbabbbbbbbb","abbaaaaaabbabaabbababaaaabbbbaaaaabaabbaaaabaa","aaaababbbbabaaaababaaaabbabbbbbabababaaabbaabb","abbbbbbbabaababaababbababaaabaaabaababbaaaabaa","babbbaaabbbbbabaaaaaaabaaaabaaabbabaabbababbbb","abbabbaaabaabaaaaaabbabbaabaaaaabababbaabbaaaa","abbaaabbbbbabbbbabaaaaaabaaabaabaaabbabbbababb","bababbbbaaabaabbbbbbabbaabbbbbaaabaaabbbbbbbba","aabaaaabbabbaabaaababbbaabbaabababaaaababbbbbb","baababbbbbbbbbbaabaabaabbbbbbababbabaaababbaba","babbabbabaaaababaabababbabaaaaaabbbaaaabaaabba","aabbbaabaabaaabbbbbbabbbbaaabababbbbbbaababaaa","abaabaaababbbabbbbaaaabaaababaabbababbbaabbbba"));
		start = "aabbbaabaabaaabbbbbbabbbbaaabababbbbbbaababaaa";
		end =   "abaabaaababbbabbbbaaaabaaababaabbababbbaabbbba";
		
		int n = new WordLadderIWithGraphs().ladderLength(start, end, dictV);
		System.out.println(n);
	}

}
