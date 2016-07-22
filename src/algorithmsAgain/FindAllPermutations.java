package algorithmsAgain;

public class FindAllPermutations {
	public static java.util.ArrayList <String> findAllPermutations (String s){
		java.util.ArrayList < String > results = new java.util.ArrayList < String > ();

		if ( s.length() <= 1 || s == null ){
			results.add(s);
			return results;
		}

		java.util.ArrayList < String > tempResults = new java.util.ArrayList < String > ();

		for ( int i = 0; i < s.length (); i++){
			char c = s.charAt ( i );
			//String without that character:
			String restOfS= s.substring (0,i ) + s.substring ( i+1, s.length () ); //Given that substring returns an empty String if the limits are off.

			tempResults = findAllPermutations ( restOfS);

			for ( int j = 0; j < tempResults.size (); j++ )
				results.add ( c + tempResults.get (j) );
		}
		return results;
	}

	public static void main ( String [] args ){
		String s = "empa";
		java.util.ArrayList < String > results = findAllPermutations ( s );
		for ( int i = 0; i < results.size (); i++ ){
			System.out.println ( results.get ( i ) );
		}
	}





}
