package other;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueuesQuickPop {

	Queue <Integer> q1 = new LinkedList <Integer>();
	Queue <Integer> q2 = new LinkedList <Integer>();
	boolean swapped = false;	

	public void push (int n){
		
		Queue <Integer> qA = swapped?q2:q1;
		Queue <Integer> qB = swapped?q1:q2;
		
		qB.add(n);
		while (!qA.isEmpty())
			qB.add(qA.remove());
		
		swapped = !swapped;
		
	}

	public int pop (){
		Queue <Integer> qA = swapped?q2:q1;
		if (qA.isEmpty()) return -1;	//TODO: Or throw exception.
		return qA.remove();		
	}
	
	public static void main (String [] args ){
		StackWithTwoQueuesQuickPop s = new StackWithTwoQueuesQuickPop();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);

		System.out.println (s.pop());
		System.out.println (s.pop());
		System.out.println (s.pop());
		
		s.push(7);
		s.push(8);
		s.push(9);

		System.out.println (s.pop());
		System.out.println (s.pop());
		System.out.println (s.pop());
		System.out.println (s.pop());
		System.out.println (s.pop());
		System.out.println (s.pop());
		System.out.println (s.pop());
		System.out.println (s.pop());
		



	}

}
