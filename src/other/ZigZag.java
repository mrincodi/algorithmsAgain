package other;

public class ZigZag {



	int zigzag ( int [] array ){

		if ( array.length == 0 ) return 0;

		int [] goingUp = new int [ array.length ];
		int [] goingDown = new int [ array.length ];
		goingUp[0]=1;
		goingDown[0]=1;

		int maxLenght=1;

		for ( int i = 1; i < array.length; i++ ){
			//Calculate goingUp[i].
			int val = 0;
			for ( int j = 0; j < i; j++){
				if ( array [ j ] < array [ i ])
					val = Math.max (goingDown [j], val );
			}
			goingUp[i]=val + 1;

			val=0;
			for ( int j = 0; j < i; j++){
				if ( array [ j ] > array [ i ])
					val = Math.max (goingUp [j], val );
			}

			goingDown[i]=val + 1;

			maxLenght=Math.max (maxLenght,goingUp[i]);
			maxLenght=Math.max (maxLenght,goingDown[i]);
		}

		return maxLenght;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array = 		{4, 1, 6, 7, 7, 8, 9, 8, 6, 8};
		int z = new ZigZag().zigzag(array);
		System.out.println(z);
	}

}
