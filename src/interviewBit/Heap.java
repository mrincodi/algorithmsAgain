package interviewBit;
public class Heap {

	private java.util.ArrayList <Integer> array;

	public Heap () {
		array = new java.util.ArrayList <Integer>();
		array.add (0);	//For simplicity, we don�t play with value 0.
	}

	public void add (int value ){
		//Add to the end and �bubble up�.
		array.add (value );

		for ( int i = array.size() -1; i >1; i = i/2 ){
			if ( array.get( i ) < array.get (i / 2) ){
				//Swap positions!
				int tempValue = array.get( i/2 );
				array.set ( i/2, array.get (i)); //OJO: Left value must be a variable.
				array.set (i, tempValue);
			}
			else
				break;
		}
	}

	public int remove ( ){
		if ( array.size () <= 1 ) return -1;

		int value = array.get ( 1 );		

		//Let�s put the last value at the end and �go down�.

		array.set ( 1, array.get (array.size () - 1 ));
		array.remove (array.size() -1 );
		int i= 1;
		while ( i< array.size () ){
			if ( i*2 >= array.size ()) break;
			if ( i*2 == array.size () - 1) {	//OJO con boundaries!
				if ( array.get(i) > array.get (i*2)){
					//Swap values.
					int temp = array.get (i*2);
					array.set (i*2, array.get(i) );
					array.set (i,temp);
				}
				break;
			}
			// Get the smaller value and position.
			int pos = 0;
			if ( array.get (i*2) < array.get (i*2+1))
				pos = i*2;
			else
				pos = i*2+1;

			if ( array.get(i) > array.get (pos)){
				//Swap values.
				int temp = array.get (pos);
				array.set (pos, array.get(i) );
				array.set (i,temp);
			}
			i=pos;
		}

		System.out.println(value);
		return value;
	}

	public void printSequential ( ){
		for ( int i = 1; i < array.size(); i++ ){
			System.out.println ( array.get (i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap h = new Heap ();

		h.add(54);
		h.add(85);
		h.add(42);
		h.add(22);
		h.add(3);
		h.add(40);
		h.add(96);
		h.add(47);
		h.add(51);
		h.add(69);
		h.add(71);
		h.add(4);
		h.add(88);
		h.add(73);
		h.add(84);
		h.add(56);
		h.add(6);
		h.add(48);
		h.add(84);
		h.add(84);
		h.add(35);
		h.add(6);
		h.add(64);
		h.add(23);
		h.add(24);
		h.add(30);
		h.add(82);
		h.add(83);
		h.add(26);
		h.add(36);
		h.add(53);
		h.add(33);
		h.add(95);
		h.add(27);
		h.add(31);
		h.add(70);
		h.add(3);
		h.add(59);
		h.add(90);
		h.add(7);
		h.add(42);
		h.add(48);
		h.add(54);
		h.add(67);
		h.add(17);
		h.add(40);
		h.add(32);
		h.add(18);
		h.add(48);
		h.add(10);
		h.add(52);
		h.add(9);
		h.add(21);
		h.add(25);
		h.add(58);
		h.add(27);
		h.add(17);
		h.add(9);
		h.add(27);
		h.add(9);
		h.add(75);
		h.add(1);
		h.add(56);
		h.add(87);
		h.add(68);
		h.add(97);
		h.add(70);
		h.add(37);
		h.add(29);
		h.add(71);
		h.add(15);
		h.add(14);
		h.add(72);
		h.add(36);
		h.add(32);
		h.add(11);
		h.add(7);
		h.add(70);
		h.add(54);
		h.add(42);
		h.add(90);
		h.add(28);
		h.add(86);
		h.add(90);
		h.add(64);
		h.add(4);
		h.add(78);
		h.add(92);
		h.add(25);
		h.add(97);
		h.add(66);
		h.add(16);
		h.add(88);
		h.add(88);
		h.add(16);
		h.add(29);
		h.add(71);
		h.add(59);
		h.add(2);
		h.add(71);

		for (int i = 0;i<110;i++){
			h.remove();
		}

		//h.printSequential();
	}

}
