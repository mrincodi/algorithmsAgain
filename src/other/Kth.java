package other;

class Node {
	int value;
	Node next;
	Node ( int value){this.value=value;this.next=null;}
}


public class Kth {

	int k = -1;

	Node getKthToLast ( Node list, int k2 ){

		k = k2;

		return getKthToLast ( list );
	}

	Node getKthToLast (Node list ){

		if ( list == null ){
			k = k-1;
			return null;
		}

		if ( k == 0 )
			return list;

		else {
			Node n = getKthToLast ( list.next);
			if ( k > 0 ){
				k--;
				return null;
			}
			else if ( k == 0 ){
				k--;
				return list;
			}
			else {
				return n;
			}
		}
	}

	public static void main ( String [] args){
		Node n = new Node (1);
		n.next = new Node (2);
		n.next.next = new Node (3);
		n.next.next.next = new Node (4);
		n.next.next.next.next = new Node (5);
		n.next.next.next.next.next = new Node (6);
		
		int val = new Kth().getKthToLast(n,4).value;
		System.out.println(val);
	}


}
