package other;

public class Fib {

	int fib ( int n ){
		return n <=1 ? n : fib ( n - 1) + fib ( n - 2 );
	}
	
	int fibDP ( int n ){
		if ( n <= 2 ) return 1;

		int [] array = new int  [ n + 1 ];	// OJO!
		array [0]=0;
		array[1]=1;
		array[2]=1;

		for ( int i = 3; i<=n; i++ )
			array [ i ] = array [ i - 1 ] + array [ i - 2 ];
			
	return array [ n ];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Fib().fib(40));

	}

}
