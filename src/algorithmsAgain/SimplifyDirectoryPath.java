package algorithmsAgain;

import java.util.Stack;

/**
 * 
Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characters.
 * @author mrincodi
 * 2016-08-02
 *
 */
public class SimplifyDirectoryPath {



	public String simplifyPath(String a) {
		String s = "";
		//StringBuffer sb = new StringBuffer ();
		Stack <String> st = new Stack <String > ();

		String [] array = a.split ("/");

		for ( int i = 0; i < array.length; i++){
			String entry = array [ i ];

			if ( entry.equals (".") || entry.equals ( "" )) {} //Do nothing.
			else if ( entry.equals ("..") ) {
				if (! st.empty() ) st.pop();
			}
			else st.push ( entry );
		}

		while (!st.empty ()){
			String dirName = st.pop ();
			s = "/" + dirName + s;  //Not the optimal way of doing this. Better use StringBuffer.
		}

		if ( s.equals ("") ) s = "/";

		return s;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
