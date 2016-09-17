package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AddOneUgly extends Thread{
	
	//static 
	int var = 0;
	AtomicInteger var2 = new AtomicInteger(0);
	
	public void run (){
		try {
			addOne();
		} catch (InterruptedException e) {
			try {
				throw new InterruptedException ( "Oops, you did it again...");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
//	synchronized
	public int addOne () throws InterruptedException{
		int qq = var;
		Thread.sleep(1);
		qq = qq + 1;
		Thread.sleep(1);
		var = qq;
		Thread.sleep(1);
		
		//System.out.println("En el thread "+ Thread.currentThread().getId() + " var vale " + var);
		
		// The following doesn't seem to help. (?)
		var2.incrementAndGet();
		System.out.println("En el thread "+ Thread.currentThread().getId() + " var2 vale " + var2);
		
		return var;
	}
	
	

}
