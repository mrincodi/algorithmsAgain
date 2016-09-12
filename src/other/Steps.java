package other;

public class Steps {


	int steps ( int n ){
		
		if ( n <= 1 ) return n;
		if ( n == 2 ) return 2;
		if ( n==3 ) return 4;
		int [] ways = new int [ n ];
		
		ways [ n - 1 ] = 1;
		
		ways [ n - 2 ] = 2;
		
		ways [ n - 3 ] = 1 + 2 + 1;
		
		for ( int i = n-4; i >=0; i--){
			ways [ i ] = ways [ i + 1] + ways [ i + 2 ] + ways [ i + 3 ];
		}
		
		return ways [ 0 ];
	
	}

	public static void main(String[] args) {
		int n = 30;
		int s = new Steps ().steps(n);
		System.out.println(s);
				

	}

}
