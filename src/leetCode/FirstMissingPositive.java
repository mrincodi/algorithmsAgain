package leetCode;

/**
 * @author mrincodi
 * 2016-11-21
 * Comment: It's the same thing as DisappearedNumbers.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        for ( int i= 0; i < nums.length; i++){
            if ( nums[i] == i + 1 ) continue;
            if ( nums[i] > nums.length || nums [ i ] <= 0 ) continue;
            
            boolean quitIt = false;
            while (! quitIt ){
                int temp = nums [ nums [ i ] - 1 ];
                nums [ nums [ i ] - 1 ] = nums [ i ];
                nums [ i ] = temp;
                if ( nums [ i ] <= 0 || nums [ i ] > nums.length || nums [ nums [ i ] - 1 ] == nums [ i ] )
                    quitIt = true;
            }
        }
        for ( int i = 0; i < nums.length; i++){
            if ( nums [ i ] != i + 1) return i+1;
        }
        
        return nums.length + 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
