package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sera1 {


	public int minimize(final List<Integer> aL, final List<Integer> bL, final List<Integer> cL) {

		int bestDiff = Integer.MAX_VALUE;
		outer:
		for ( int i = 0; i < aL.size(); i++){
			int a = aL.get(i);
			middle:
			for ( int j = 0; j < bL.size(); j++){
				int b = bL.get(j);
				inner:
				for ( int k = 0; k < cL.size(); k++){
					int c = cL.get(k);
					int diffAB=Math.abs(a-b);
					int diffBC=Math.abs(b-c);
					int diffABC = Math.max(diffAB, diffBC);
					bestDiff = Math.min(bestDiff, diffABC);

				}
			}
		}
		return bestDiff;
	}

	public static void main(String[] args) {
		ArrayList <Integer> aL = new ArrayList <Integer> ( Arrays.asList(1,4,10));
		ArrayList <Integer> bL = new ArrayList <Integer> ( Arrays.asList(2,15,20));
		ArrayList <Integer> cL = new ArrayList <Integer> ( Arrays.asList(10,12));
		int min = new Sera1().minimize(aL, bL, cL);
		System.out.println(min);
	}

}
