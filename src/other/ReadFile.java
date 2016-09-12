package other;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFile {

	void printFile ( String fileName ){
		try {
			FileReader fr = new FileReader ( fileName);
			BufferedReader br = new BufferedReader ( fr );

			String s = br.readLine();
			while ( s != null ){
				System.out.println(s);
				s = br.readLine ();
			}
		}
		catch ( Exception e ){ e.printStackTrace (); }
	}		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReadFile().printFile("/Users/mrincodi/qq");
	}

}
