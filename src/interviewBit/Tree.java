package interviewBit;

public class Tree {
	int value;
	Tree left;
	Tree right;

	public Tree (int value){
		this.value=value;
		this.left = null;
		this.right = null;
	}

	public void add ( int value ){
		if (value <= this.value ){ //Careful with the comparisons! Not a good idea to call the variable equal to the attribute!
			if ( this.left == null )
				this.left = new Tree (value );
			else
				this.left.add (value);
		}
		else {
			if ( this.right == null )
				this.right = new Tree (value );
			else
				this.right.add (value);
		}
	}

	public java.util.ArrayList <Integer> inOrder ( ){
		java.util.ArrayList <Integer> leftResult = new java.util.ArrayList <Integer> ();
		java.util.ArrayList <Integer> rightResult = new java.util.ArrayList <Integer> ();

		if ( this.left != null )
			leftResult = this.left.inOrder ();
		if ( this.right != null )
			rightResult = this.right.inOrder ();	// OJO con estos errores! Era right, no left!

		leftResult.add (this.value); //Concatenate the values
		leftResult.addAll (rightResult); //Concatenate the values

		return leftResult;

	}

	public static void main ( String [] args ){
		Tree t= new Tree (30);
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

		java.util.ArrayList <Integer> list = t.inOrder ();

		for ( int i = 0 ; i < list.size (); i++ ){
			System.out.println ( list.get (i) );
		}
	}
}