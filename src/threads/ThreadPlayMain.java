package threads;

public class ThreadPlayMain {

	public static void main(String[] args) {
		ThreadPlay tp = new ThreadPlay();
		AddOne addOne = new AddOne();
		tp.addOne=addOne;
		for ( int i = 0; i < 100; i++){
			Thread t = new Thread(tp);
			t.start();
		}

	}

}
