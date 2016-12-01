package hackerrank;

/**
 * Dismiss.
 * 2016-11-26
 * @author mrincodi
 *
 */
public class QQ {

	static int minMoves(int[] avg) {
		int result = Integer.MAX_VALUE;
		int result1 = 0;
		int result2 = 0;
		
		if (avg.length == 0) return 0;

		int first = avg[0];
		int last = avg[avg.length-1];

		//Check that in the rest there is at least a different one.

		boolean solved=true;
		outer:
			for ( int j = 1; j< avg.length;j++){
				if (avg[j] != first){

					for ( int k = j+ 1; k < avg.length;k++){
						if ( avg[k] != avg[j]){
							solved=false;
							break outer;
						}
					}
					return 0;
				}
			}

		if (solved) return 0;

		//Find first change.
		outer:
			for ( int i = 1; i < avg.length;i++){
				if ( avg[i] != first){

					int[] avg2 = new int[avg.length];
					System.arraycopy(avg, 0, avg2, 0, avg.length);
					avg2[i-1]=Math.abs(first-1);
					avg2[i]=first;

					result1=1+minMoves(avg2);
					break outer;
				}
			}



		outer2:
			for ( int i = avg.length-2; i >=0;i--){
				if ( avg[i] != last){

					int[] avg2 = new int[avg.length];
					System.arraycopy(avg, 0, avg2, 0, avg.length);
					avg2[i+1]=Math.abs(last-1);
					avg2[i]=last;

					result2=1+minMoves(avg2);
					break outer2;
				}
			}

			result=Math.min(result1,result2);
			return result;
	}


	public static void main (String [] args){
		int [] a = { 1,1,0,1};
		int p = QQ.minMoves(a);
		System.out.println(p);

	}
}
