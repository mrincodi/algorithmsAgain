package threads;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Anita ve una nueva tina.");
		System.out.println("Now, thread " + Thread.currentThread().getId() + " is running!");
	}

}
