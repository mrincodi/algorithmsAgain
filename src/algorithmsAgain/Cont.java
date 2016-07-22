package algorithmsAgain;
/**
 * Gets maximum sub-array with only positive integers.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cont {
	
	

	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
		ArrayList <Integer> maxSoFar = new ArrayList<Integer>  ();
		long maxSumSoFar = 0;

		for ( int i = 0; i < a.size(); ){
			//If current value is non-negative, start collecting values.
			if (a.get(i)>=0){
				System.out.println ("Hola. " + i );
				//Start collecting the positive values.
				int j=i;
				ArrayList <Integer> candidate = new ArrayList <Integer> ();
				long sum=0;
				while ( j < a.size() && a.get(j) >=0 ){
					System.out.println ( "Entro al ciclo con j = " + j + " y valor "+ a.get (j));
					candidate.add (a.get(j));
					sum+=a.get(j);
					j++;
					System.out.println( "Y sum es " + sum);
				}

				if ( sum > maxSumSoFar || ( sum == maxSumSoFar && candidate.size() > maxSoFar.size())){      
					maxSoFar = candidate;
					maxSumSoFar = sum;
					System.out.println ( "Bien. maxSumSoFar ahora es " + maxSumSoFar);
				}

				i=j;

				System.out.println ( "Y tengo que i es "+ i);
			}
			else
				i++;
		}

		return maxSoFar;
	}


	public static void main(String[] args) {

		ArrayList <Integer> a = new ArrayList <Integer> ();
		
		a.addAll(Arrays.asList(6, 1, 2, 5, -7, 2, 5, 1967513926, 1540383426, -1303455736, -521595368));

		Integer [] qq = { 5,6,7,8};
		a.addAll(Arrays.asList(qq));
		Cont c=new Cont ();
		ArrayList <Integer> solution = c.maxset (a);
		
		for ( int i = 0; i < solution.size(); i++){
			System.out.print(solution.get (i) + " ");
		}

	}

}
