package hackerrank;

public class P2VMWare {

	static int minMoves(int[] avg) {
		
		//All the zeroes to the left.
		if ( avg.length <= 1 ) return 0;
		
		//Find all the zeroes and move them to the left.
		int zeroPointer = -1;	//Upper limit of zero area (inclusive) to the right.
		int onePointer = -1; //Upper limit of one area (inclusive) to the right.
		int totalStepsZeroLeft = 0;
		int totalStepsOneLeft = 0;
		for ( int i = 0; i < avg.length; i++){
			int p = avg[i];
			if ( p == 0){
				zeroPointer++;
				totalStepsZeroLeft += i - zeroPointer;
			}
			else{
				onePointer++;
				totalStepsOneLeft += i - onePointer;
			}
			
		}
		
		int totalSteps = Math.min(totalStepsZeroLeft, totalStepsOneLeft);
		return totalSteps;
	}
	
	
	public static void main ( String [] args ){
		int [] avg = { 1,1,0,1,0,1 };
		
		int p = P2VMWare.minMoves(avg);
		System.out.println(p);
		
		
	}
}
