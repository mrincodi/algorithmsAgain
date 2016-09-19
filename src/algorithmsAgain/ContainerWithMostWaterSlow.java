package algorithmsAgain;

import java.util.ArrayList;

public class ContainerWithMostWaterSlow {

		public int maxArea(ArrayList<Integer> a) {
		    int maxArea = 0;
		    for ( int i = 1; i < a.size(); i++){
		        for ( int j = 0; j < i; j++){
		            int thisArea = Math.min(a.get(j),a.get(i))*(i - j);
		            maxArea = Math.max ( maxArea, thisArea );
		            
		        }
		    }
		    return maxArea;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
