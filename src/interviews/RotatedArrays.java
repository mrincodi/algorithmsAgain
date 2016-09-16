package interviews;

public class RotatedArrays {

	public int findPosition ( int [] array, int value ) throws Exception{
		if ( array.length == 0 ) throw new Exception ("Number is not in the array" );
		return findPosition (array, value, 0, array.length - 1);
	}

	public int findPosition ( int [] array, int value, int start, int end ) throws Exception{
		if ( start == end ){
			if ( array [ start ] == value ) return start;
			else throw new Exception ("Number is not in the array" );
		}

		//Split the array and look for the value!
		int middle = (start + end)/2;

		//Look for the corners of each section.
		if ( array [ start ] <= array [ middle  ] ){ //It is sorted!
			if ( array [ start ] <= value && array [ middle  ] >= value ){
				return findPosition (array, value, start,  middle );
			}
			else return findPosition (array, value, middle + 1, end);
		}

		if ( array [ middle + 1 ] <= array [ end ] ){ //It is sorted!
			if ( array [ middle + 1 ] <= value && array [end ] >= value ){
				return findPosition (array, value, middle + 1,  end);
			}
			else return findPosition (array, value, start, middle );
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		int [] array = {3, 4, 5, 6, 1, 2};
		
		int pos = new RotatedArrays().findPosition(array, 5);
		
		System.out.println(pos);

	}
}

