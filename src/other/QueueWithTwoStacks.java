package other;

import java.util.Stack;

public class QueueWithTwoStacks {

	Stack <Integer> s1 = new Stack <Integer> ();
	Stack <Integer> s2 = new Stack <Integer> ();
	
	public void add(int n){
		s1.push(n);
	}
	
	public int remove(){
		if(!s2.isEmpty())return s2.pop();
		while (!s1.isEmpty())
			s2.push(s1.pop());
		
		if (s2.isEmpty())return -1;	//TODO: or throw exception.
		return s2.pop();
	}

	
	public static void main(String[] args) {
		
		QueueWithTwoStacks q = new QueueWithTwoStacks();

		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);

		System.out.println (q.remove());
		System.out.println (q.remove());
		System.out.println (q.remove());
		
		q.add(7);
		q.add(8);
		q.add(9);

		System.out.println (q.remove());
		System.out.println (q.remove());
		System.out.println (q.remove());
		System.out.println (q.remove());
		System.out.println (q.remove());
		System.out.println (q.remove());
		System.out.println (q.remove());
		System.out.println (q.remove());
		q.add(7);
		q.add(8);
		q.add(9);
		System.out.println (q.remove());
		System.out.println (q.remove());
		System.out.println (q.remove());
		System.out.println (q.remove());

	}

}
