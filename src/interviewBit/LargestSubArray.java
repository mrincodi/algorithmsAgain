package interviewBit;

public class LargestSubArray {
	public int largestSubArray ( int [] array ){

		int maxArraySoFar = array[0];
		int maxArrayWithPreviousValue = array[0];

		for ( int i=1; i < array.length; i++ ){
			int val = array[i];
			int maxArrayWithThisValue = Math.max (
				val + maxArrayWithPreviousValue, val );
			
			maxArraySoFar = Math.max (maxArraySoFar, maxArrayWithThisValue );

			maxArrayWithPreviousValue=maxArrayWithThisValue;
		}
		return maxArraySoFar;
	}

	public static void main ( String [] args ){
		int [] array = { -3, -1, 4, -3, 5,32,-13,14,-100,0,0,3};
		int max = new LargestSubArray().largestSubArray(array);
		System.out.println(max);
		
	}
}
