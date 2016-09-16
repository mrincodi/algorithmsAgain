package other;

import java.util.Arrays;

public class JustPlaying {

	public static void main(String[] args) {


		int [] a = { 7,8,6,3,6,0,9};
		int [] b = new int [0];

		b = Arrays.copyOf(a, a.length);

		Long 	y = new Long(7L);
		Long z = new Long(34563456845843564L);
		
		if ( y.compareTo(z) < 0)System.out.println(y + " es mAs pequeño que " + z);





	}

}
