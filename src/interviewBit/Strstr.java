package interviewBit;

public class Strstr {


	public int strStr(final String haystack, final String needle) {

		//Implementing the O (m*n) solution.

		if ( haystack.length () == 0 || needle.length () == 0 ) return  -1;
		if ( haystack.length () < needle.length () ) return  -1;

		for ( int i = 0; i < ( haystack.length () - needle.length () + 1); i++){
			boolean nextChar=true;
			for ( int j = i; nextChar && j < i + needle.length (); j++){
				if (haystack.charAt(j) != needle.charAt(j - i)) nextChar=false;
			}
			if ( nextChar) return i;
		}

		return -1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
