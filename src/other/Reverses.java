package other;

public class Reverses {

	String reverse ( String s ){
		String t = "";
		for ( int i = 0; i < s.length (); i++ )
			t = t + s.charAt (s.length () - i - 1);

		return t;
	}

	String reverse2 ( String s ){
		StringBuffer sb = new StringBuffer ();
		for ( int i = 0; i < s.length (); i++ )
			sb.append ( s.charAt (s.length () - i - 1));

		return sb.toString ();
	}
	
	String reverse3 ( String s ) {
		char [] array = s.toCharArray ();

		for ( int i = 0; i < s.length () / 2; i++ ){
			char temp = array [ i ];
			array [ i ] = array [ s.length () - i - 1 ];
			array [ s.length () - i - 1 ] = temp;
		}

		String t = new String ( array ); //From array of chars to String.
		return t;
	}

		
	public static void main ( String [] args ){
		
		String a = "Hello!";
		String b = new Reverses().reverse3(a);
		System.out.println(b);
	}
}
