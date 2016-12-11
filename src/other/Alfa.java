package other;

public class Alfa {

	public void sera (){
		System.out.println("De alfa");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gamma g = new Gamma();
		g.sera();
		
	}

}

class Beta extends Alfa{
	@Override
	public void sera (){
		System.out.println("De Beta");
	}
}

class Gamma extends Beta{
	@Override
	public void sera (){
		super.sera();
		System.out.println("De Gamma");
	}
}


