package designPatternsFactory;

public class Square implements Shape {

	private int side =0;

	public Square ( int side){
		this.side=side;
	}

	@Override
	public int getArea() {
		return this.side*this.side;
	}


}
