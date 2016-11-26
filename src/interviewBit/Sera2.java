package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sera2 {


	public int minimize(final List<Integer> aL, final List<Integer> bL, final List<Integer> cL) {

		int bestDiff = Integer.MAX_VALUE;
		int i=0, j=0, k=0;
		int a=0,b=0,c=0;

		while (i < aL.size()){
			a = aL.get(i);

			//Get the best position for b:

			while ( j < bL.size()&& (b=bL.get(j))<a) j++;

			//Get the best position for c:

			while ( k < cL.size()&& (c=cL.get(k))<b) k++;

			int diffAB = Math.abs(a-b);
			int diffBC = Math.abs(b-c);
			
			int diffABC=Math.max(diffAB, diffBC);
			bestDiff = Math.min(bestDiff, diffABC);

			i++;		
		}
		return bestDiff;
	}

	public static void main(String[] args) {
		ArrayList <Integer> aL = new ArrayList <Integer> ( Arrays.asList(1,4,10));
		ArrayList <Integer> bL = new ArrayList <Integer> ( Arrays.asList(2,15,20));
		ArrayList <Integer> cL = new ArrayList <Integer> ( Arrays.asList(10,12));
		int min = new Sera2().minimize(aL, bL, cL);
		System.out.println(min);
	}

}


//
//
//middle:
//	while ( j < bL.size()){
//		int b = bL.get(j);
//		inner:
//			while ( k < cL.size()){
//				int c = cL.get(k);
//				int diffAB=Math.abs(a-b);
//				int diffBC=Math.abs(b-c);
//				int diffABC = Math.max(diffAB, diffBC);
//				bestDiff = Math.min(bestDiff, diffABC);
//
//				if ( c > b ){
//					if ( k > 0 ) k--;
//					j++;
//					continue middle;
//				}
//
//				if ( c < b && k < cL.size()){
//					k++;
//				}
//			}
//
//		if ( b > a ){
//			if ( j > 0 ) j--;
//			i++;
//			continue outer;
//		}
//		if ( b < a && j < bL.size()){
//			j++;
//		}
//	}
//i++;
