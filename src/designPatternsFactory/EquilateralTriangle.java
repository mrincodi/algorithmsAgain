package designPatternsFactory;

public class EquilateralTriangle implements Shape{

	private int side;
	
	public EquilateralTriangle (int side){
		this.side=side;
	}
	
	@Override
	public int getArea (){
		double a = Math.pow((double) this.side, 2)*Math.sqrt(3)/4;
		return (int)a;
	}
}
