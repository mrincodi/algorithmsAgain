package threads;

public class MyRunnableMain {

	public static void main(String[] args) throws InterruptedException {
		for ( int i = 0; i < 20; i++){
			Thread t = new Thread (new MyRunnable());
			t.start();
			Thread.sleep(1000);
		}
	}

}
