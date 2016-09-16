package threads;

public class MyThreadMain {

	public static void main(String[] args) {
		for ( int i = 0; i < 20; i++){
			MyThreadClass empa = new MyThreadClass ();

			empa.start();	
		}		
		System.out.println ("Soy main. Thread " +
				Thread.currentThread().getId() +
				" is running");

	}

}
