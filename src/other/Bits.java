package other;

public class Bits {

	 int countBits(int x){
		 int n = 0;
		 while ( x != 0 ){
			 n += x&1;
			 x=x>>>1;
		 }
		 return n;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = Integer.MIN_VALUE;
		x = 0b11111111111111111111111111111111;
		int q = new Bits().countBits(x);
		System.out.println(x + "   " + q);
	}

}
