package other;

public enum Empanadas {

	POLLO, CARNE, VEGETARIANA, PAPA, ARROZ, MIXTA;
	
	public int quéTanRica (){
		if ( this == Empanadas.POLLO ) return 10;
		return 0;
	}
	public static void main(String[] args) {
		 //TODO Auto-generated method stub
}

}
