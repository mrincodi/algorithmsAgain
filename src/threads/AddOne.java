package threads;

public class AddOne {

	int val = 0;
	
	//synchronized 
	int addOne () throws InterruptedException{
//		System.out.println( );
		val = val + 1;
		Thread.sleep(1);
		System.out.println("Buenas tardes. Soy el thread " + Thread.currentThread().getName() + ", " + Thread.currentThread().getId() + " y val vale " + val );
		
		return val;
	}
}
