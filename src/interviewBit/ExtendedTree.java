package interviewBit;

public class ExtendedTree  {
	int value;
	int weight;
	ExtendedTree left;
	ExtendedTree right;

	public ExtendedTree (int value){
		this.value = value;
		this.weight = 1;
		this.left = null;
		this.right = null;
	}

	public void add ( int value ){
		this.weight += 1;
		if ( value <= this.value ){
			if ( this.left == null )
				this.left = new ExtendedTree (value );
			else
				this.left.add (value);
		}
		else {
			if ( this.right == null )
				this.right = new ExtendedTree (value );
			else
				this.right.add (value);
		}
	}

	public int getRank ( int position ){
		if ( position <=0 || position > this.weight ) return -1;	// Should be throw Exception.
		int currentPosition = 1;
		if ( this.left != null )
			currentPosition = this.left.weight + 1;

		if ( currentPosition  == position ) return this.value;

		if ( position < currentPosition ) return this.left.getRank ( position );
		else return this.right.getRank (position - currentPosition );
	}
	
	public static void main ( String [] args ){
		ExtendedTree t = new ExtendedTree (30);
		t.add (15);
		t.add (5);
		t.add (8);
		t.add (14);
		t.add (7);
		t.add (4);
		t.add (29);
		t.add (80);
		t.add (100);
		t.add (110);

		System.out.println(t.getRank(4));
//		java.util.ArrayList <Integer> list = t.inOrder ();
//
//		for ( int i = 0 ; i < list.size (); i++ ){
//			System.out.println ( list.get (i) );
//		}
		
	}
	
}