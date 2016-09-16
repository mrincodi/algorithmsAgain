package threads;

public class ThreadPlay implements Runnable{

	AddOne addOne;
	
	@Override
	//synchronized		//You can put synchronized here!
	public void run (){
		try {
			addOne.addOne();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
