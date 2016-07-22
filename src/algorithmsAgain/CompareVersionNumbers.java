package algorithmsAgain;

/**
 * Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
import java.util.ArrayList;

public class CompareVersionNumbers {

	public ArrayList <String> strtokDot ( String a){
		ArrayList < String > al = new ArrayList < String > ();

		String currentWord="";

		for ( int i = 0; i < a.length(); i++){
			if ( a.charAt(i) != '.' ){
				//This is not optimal.
				currentWord = currentWord + a.charAt(i);
			}
			else {
				if (currentWord.length()==0) {
					currentWord="0";
				}
				al.add (currentWord);
				currentWord="";
			}
		}
		if (currentWord.length()==0) {
			currentWord="0";
		}
		al.add (currentWord);
		return al;
	}

	public int cmp (String a, String b){
		if ( a.length ()==0 ) a = "0";
		if ( b.length ()==0 ) b = "0";

		int i = 0;
		int j = 0;

		//Let's compare the "numbers"!

		if ( a.length () > b.length ()){
			for ( ; i< a.length () - b.length (); i++){
				if ( a.charAt(i) != '0' ) return 1;
			}
		}

		if ( b.length () > a.length ()){
			for ( ; j< b.length () - a.length (); j++){
				if ( b.charAt(j) != '0' ) return -1;
			}
		}

		//Both have the same size (or there are zeroes at the beginning)! Now we can compare
		while ( i < a.length ()){
			if ( a.charAt(i)>b.charAt(j) ) return 1;
			if ( b.charAt(j)>a.charAt(i) ) return -1;
			i++;
			j++;
		}

		return 0;

	}

	public int compareVersion(String a, String b) {

		//Get the first numbers.
		//I could use a tokenizer!
		ArrayList <String> numbersA = strtokDot(a);
		ArrayList <String> numbersB = strtokDot(b);


		for ( int i = 0; i < numbersA.size(); i++ ){

			if (i==numbersB.size()){ //a has more terms than b, and b "starts with a".
				//Check the special case where a = "b.0"
				if (i==numbersA.size() - 1 && numbersA.get(i).equals("0"))
					return 0;
				return 1;
			}

			String numberA = numbersA.get(i);
			String numberB = numbersB.get(i);

			int compare = cmp (numberA, numberB);

			if ( compare != 0) return compare;

			//Simply continue to the next pair of numbers.
		}

		if (numbersB.size() > numbersA.size()){
			//Check the special case where b = "a.0"
			if ( numbersB.size() == numbersA.size() + 1 && numbersB.get (numbersB.size()-1).equals("0"))
				return 0;
			return -1;
		}
		else {
			return 0;
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
