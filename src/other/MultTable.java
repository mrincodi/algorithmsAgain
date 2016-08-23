package other;

public class MultTable {

	void multTable ( int n ){
		for ( int i = 1 ; i <= n ; i++){
			for ( int j = 1; j <=n; j++ ){
				int prod = i * j;
				System.out.print ( prod + "\t");
			}
			System.out.println ();
		}
	}
	
	public static void main(String[] args) {
		new MultTable().multTable (12);

	}

}
