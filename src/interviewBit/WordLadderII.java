package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
If there are multiple such sequence of shortest length, return all of them. Refer to the example for more details.

Example :

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
 Note:
All words have the same length.
All words contain only lowercase alphabetic characters.

 * @author mrincodi
 * 2016-11-16
 * Comment: A very difficult problem! I did a BFS with a queue made of... paths!
 * For the graph, I used a matrix.
 * Also, I used a "tempVisited" so I could create paths to the same node in the same level from different paths.
 * Finally, in the tests some dictionaries had repeated words (tsk, tsk...).
 * 
 */
public class WordLadderII {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
		ArrayList<ArrayList<String>> resultW = new ArrayList<ArrayList<String>> ();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();


		if ( start.equals(end) ) {
			resultW.add(new ArrayList<String>(Arrays.asList(start)));
			return resultW;
		}

		//Remove repeated words in the dictionary (really??)
		LinkedHashSet<String>dictSet = new LinkedHashSet<String>();
		for (String word:dict){
			dictSet.add(word);
		}
		dict = new ArrayList<String> ();
		for (String word:dictSet){
			dict.add(word);
		}

		//Let's create the graph.
		int n = dict.size();
		boolean matrix [][] = new boolean[n][n];
		for ( int i = 0; i <n; i++)
			for ( int j = 0; j < n; j++ )
				matrix[i][j] = areNeighbors ( dict.get(i), dict.get(j));

		Queue  <ArrayList<Integer>> q = new LinkedList <ArrayList<Integer>>();
		int indexOfStart = dict.indexOf(start);
		int indexOfEnd = dict.indexOf(end);

		q.add ( new ArrayList <Integer> (Arrays.asList (dict.indexOf(start) )));
		q.add(null);

		boolean found = false;
		HashSet <Integer> visited = new HashSet <Integer> ();
		HashSet <Integer> tempVisited = new HashSet <Integer> ();
		visited.add(indexOfStart);

		while ( !q.isEmpty() ){
			ArrayList <Integer> indexes = q.remove ();

			if ( indexes == null ){
				if ( found )
					return toWords (result, dict);

				if ( !q.isEmpty () ){
					q.add (null);
					visited.addAll(tempVisited);
					tempVisited=new HashSet <Integer> ();
				}
				
				continue;
			}

			int lastIndex = indexes.get(indexes.size() - 1);
			if ( lastIndex == indexOfEnd ){
				found = true;
				result.add (indexes);
				continue;
			}

			if ( !found) {
				//Get all neighbors of the last word.
				for ( int i = 0; i < n; i++ ){
					if ( !visited.contains (i) && matrix [ lastIndex][i] ){
						tempVisited.add(i);
						ArrayList <Integer> newList = new ArrayList <Integer> (indexes);
						newList.add(i);
						q.add(newList);
					}
				}
			}
		}
		return resultW;
	}

	private ArrayList<ArrayList<String>> toWords(ArrayList<ArrayList<Integer>> result, ArrayList<String> dict) {
		ArrayList<ArrayList<String>> resultW = new ArrayList<ArrayList<String>>();
		for (ArrayList<Integer> indexes: result ){
			ArrayList<String> aList = new ArrayList<String>();
			for (int index:indexes){
				aList.add(dict.get(index));
			}
			resultW.add(aList);
		}
		return resultW;
	}

	private boolean areNeighbors(String string, String string2) {
		if (string.length()!= string2.length()) return false;
		int diff = 0;

		for ( int i = 0; i < string.length();i++){
			if ( string.charAt(i)!= string2.charAt(i)){
				diff++;
				if (diff>1) return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		String start = "bbaa";
		String end = "babb";

		ArrayList<String> dict = new ArrayList<String> ( Arrays.asList( "baba","abba","aaba","bbbb","abaa","abab","aaab","abba","abba","abba","bbba","aaab","abaa","baba","baaa","bbaa","babb"));
		ArrayList<ArrayList<String>> sols = new WordLadderII().findLadders(start, end, dict);
		
		for ( ArrayList<String> sol: sols){
			System.out.println(sol);
		}

	}

}
