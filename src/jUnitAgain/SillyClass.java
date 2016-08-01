package jUnitAgain;

public class SillyClass {

	public static int multiply (int x, int y, boolean kowabunga){
		if (!kowabunga)
			return x*y;
		else {
			System.out.println("KoWaBuNgA!!");
			return ((x>>1)*(y>>1));
		}
					
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int qq = multiply (5758,7890, false);
		
		System.out.println(qq);
	}

}
