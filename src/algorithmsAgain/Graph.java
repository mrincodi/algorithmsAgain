package algorithmsAgain;

public interface Graph {
	public void addVertex ( int value );
	public void addEdge ( int value1, int value2 );
	public void removeVertex ( int value );
	public java.util.ArrayList <Integer> getBFS ( int value );
	public java.util.ArrayList <Integer> getDFS ( int value );
}
