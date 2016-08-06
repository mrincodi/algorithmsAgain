package algorithmsAgain;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
 Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
 *
 *
 *
(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
In the given example,
["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")

 * @author mrincodi
 * 
 * 2016-08-03
 * Comment: Yeah, this works and all, but could be enhanced a lot 
 * with dynamic programming.
 * 
 * Namely, by having a HashSet <String, ArrayList<ArrayList<String>>>
 * where I'd save the results for string I have already worked with.
 *
 */
public class PalindromePartitioning {


	public ArrayList<ArrayList<String>> partition(String a) {

		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>> ();

		if ( a.length () == 0 ) return results;

		if ( a.length () == 1 ) {
			ArrayList <String> letterArray = new ArrayList <String> ();
			letterArray.add(a);
			results.add (letterArray);
			return results;
		}

		for ( int i = 1; i < a.length(); i++){
			//System.out.println("Hey!!");
			String initial = a.substring (0,i);
			if ( isPalindrome (initial ) ){
				ArrayList<ArrayList<String>> subResults = new ArrayList<ArrayList<String>>  ();
				String rest = a.substring ( i, a.length () );
				subResults = partition (rest);
				for ( int j = 0; j < subResults.size(); j++){
					subResults.get(j).add(0,initial);
					results.add(subResults.get(j));
				}
			}
		}
		if (isPalindrome(a)){
			ArrayList<String> wordL = new ArrayList<String> ();
			wordL.add(a);
			results.add(wordL);
		}
		return results;
	}

	public boolean isPalindrome (String s){
		if (s.length () <=1 ) return true;
		if (s.charAt(0)!=s.charAt(s.length()-1)) return false;
		return isPalindrome (s.substring (1,s.length() - 1 ));
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word = "aa bb aa";
		ArrayList<ArrayList<String>> p= new PalindromePartitioning().partition(word);
		for ( int i = 0; i < p.size(); i++){
			for  ( int j = 0; j < p.get(i).size(); j++){
				System.out.print(p.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
