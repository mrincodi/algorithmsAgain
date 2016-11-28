package hackerrank;

/**
 * Dismiss
 * @author Mario
 * 2016-11-26
 */
public class Prob2 {


	
	static int minMoves(int[] avg) {
		return Math.min(minMoves(avg,true),minMoves(avg,false));
	}


	private static int minMoves(int[] avg, boolean fromLeft) {
		if ( isItReady (avg)) return 0;
		if (fromLeft){
			//Find the first change.
			//Then swap and call method again.
			for ( int i = 1; i < avg.length; i++){
				if (avg[i-1]!=avg[i]){
					//Change found. swap.
					int [] avg2 = new int [avg.length];
					System.arraycopy(avg, 0, avg2, 0, avg.length);
					
					avg2[i-1]=avg[i];
					avg2[i]=avg[i-1];
					return 1 + minMoves (avg2, fromLeft);
				}
			}
		}
		else {
			//Find the first change from the right.
			//Then swap and call method again.
			for ( int i = avg.length - 2; i >=0; i--){
				if (avg[i+1]!=avg[i]){
					//Change found. swap.
					int [] avg2 = new int [avg.length];
					System.arraycopy(avg, 0, avg2, 0, avg.length);
					avg2[i+1]=avg[i];
					avg2[i]=avg[i+1];
					return 1 + minMoves (avg2, fromLeft);
				}
			}
		}
		
		return 0;
	}


	private static boolean isItReady(int[] avg) {
		int numCh = 0;
		for ( int i = 1; i < avg.length; i++ ){
			if ( avg[i] != avg[i-1]) numCh++;
			if ( numCh > 1 ) return false;
		}
		return true;
	}


	public static void main (String [] args){
		int [] a = { 1,1,0,1,0,1,0,0,0,0,1,1,1,1,0,1};
		int p = Prob2.minMoves(a);
		System.out.println(p);

	}
}
