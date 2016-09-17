package threads;

public class MyBowingDeadlock {

	static class Persona {

		public final String nombre;

		public Persona (String nombre){
			this.nombre=nombre;
		}

		public synchronized void bow (Persona p){
			String who = this.nombre;
			String toWho = p.nombre;
			System.out.println("Soy " + who + ", y con toda cortesía me inclino ante vuesa merced.");
			System.out.println("Soy " + toWho + ", y de igual manera...");
			System.out.println( "Weeeee...");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p.bowBack (this);
		}

		public synchronized void bowBack  (Persona p){
			String toWho=p.nombre;
			String who = this.nombre;
			System.out.println("...por ser " + who + ", me inclino ante usted, " + toWho);
		}




		public static void main(String[] args) {
			Persona pepe = new Persona("Pepe");
			Persona juan = new Persona("Juan");

			new Thread (
					new Runnable (){
						public void run(){
							pepe.bow( juan);
						}
					}).start();

			new Thread(
					new Runnable () {
						public void run(){
							juan.bow(pepe);
						}
					}).start();
		}
	}

}
