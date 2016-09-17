package threads;

public class ThreadTestMain {

	public static void main(String[] args) throws InterruptedException {

		AddOneUgly aou = new AddOneUgly ();
		for ( int i = 0; i < 1000; i++){
			Thread t = new Thread (aou);
			t.start();
			//t.interrupt();
			//t.join();	//Solves all your problems... but then again you might as well not use threads at all.
		}
		
		System.out.println(aou.var);
		//Thread.sleep(1000);
		System.out.println("-->" + aou.var);
		
	}

}
