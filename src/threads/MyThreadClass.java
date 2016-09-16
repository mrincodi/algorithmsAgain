package threads;

public class MyThreadClass extends Thread{

	@Override
	public void run(){
		System.out.println("Al reparar olla, hallo rara perla.");
		System.out.println("Thread " + Thread.currentThread().getId() + " is running!!");
	}
	


}
