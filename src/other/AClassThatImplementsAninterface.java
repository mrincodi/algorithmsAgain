package other;

public class AClassThatImplementsAninterface implements AnInterface {

	int var = 1;
	
	@Override
	public int method() {
		var = 2;
		System.out.println(var);
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
