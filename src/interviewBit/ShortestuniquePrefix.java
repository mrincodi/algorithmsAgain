package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
Find shortest unique prefix to represent each 
word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov
 NOTE : Assume that no word is prefix 
 of another. In other words, the representation is always possible. 
 * @author mrincodi
 * 2016-08-08
 * Comments: Used this hint below: Prefix tree or Trie 
 * ( https://www.topcoder.com/community/data-science/
 * data-science-tutorials/using-tries/ )
  ===> Assume you have all the prefixes of the word stored in the tree 
  along with their frequencies. Is it possible to arrive at the solution now ?
 */
class Node {
	char c;
	int freq;
	HashMap <Character, Node> h;

	Node (char c){
		this.c=c;
		this.freq=1;
		this.h=new HashMap <Character, Node> ();
	}

	void addWord (String word){
		if ( word.length () == 0 ) return;

		char c = word.charAt(0);
		String wordLeft = word.substring (1, word.length());
		
		if (this.h.containsKey(c)){ // Si síIla contiene.
			this.h.get(c).freq++;
		}
		else {
			Node newNode = new Node (c);
			this.h.put (c,newNode);
		}
		this.h.get(c).addWord ( wordLeft );
	}

	//Recursive function.
	String getSUP (String word){
		StringBuffer sb = new StringBuffer();

		if (word == null || word.length () == 0 || this.h.size() == 0) return sb.toString ();    

		//Get the child with the next word.

		char c = word.charAt(0);
		sb.append(c+"");

		Node nextNode = this.h.get(c);

		if ( nextNode.freq != 1){
			String wordLeft = word.substring (1, word.length());
			sb.append( nextNode.getSUP (wordLeft));
		}
		return sb.toString();

	}
}

public class ShortestuniquePrefix {

	public ArrayList<String> prefix(ArrayList<String> a) {

		ArrayList<String> results = new ArrayList<String> ();
		Node t = new Node ('X');

		//Fill up the tree.
		for ( String s : a)
			t.addWord (s);

		for ( String s : a)
			results.add(t.getSUP(s));

		return results;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ShortestuniquePrefix sup = new ShortestuniquePrefix ();
		ArrayList<String> a = new ArrayList<String> (Arrays.asList("zebra","dog","duck","dot"));
		ArrayList<String> results = sup.prefix(a);
		
		for ( String s : results ){
			System.out.println(s);
		}
	}

}
