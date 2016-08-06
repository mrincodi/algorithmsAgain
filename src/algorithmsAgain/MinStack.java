package algorithmsAgain;

import java.util.ArrayList;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack? 
A: In this case, return -1.

Q: What should pop do on empty stack? 
A: In this case, nothing. 

Q: What should top() do on empty stack?
A: In this case, return -1
 NOTE : If you are using your own declared global variables, 
 make sure to clear them out in the constructor. 

 * @author mrincodi
 *
 * Comment: I used ArrayLists, but I could have used stacks.
 */
public class MinStack {

	    ArrayList <Integer> al =   new ArrayList <Integer> ();
	    ArrayList <Integer> mins = new ArrayList <Integer> ();
	    
	    public void push(int x) {
	        al.add(x);
	        if ( mins.size()==0) mins.add (x);
	        else {
	            int min = Math.min (x, mins.get(mins.size()-1));
	            mins.add(min);
	        }
	    }

	    public void pop() {
	        if ( al.size() == 0 ) return;
	        al.remove(al.size()-1);
	        mins.remove (mins.size() - 1 );
	    }

	    public int top() {
	        if (al.size()== 0) return -1;
	        return al.get ( al.size()-1 );
	    }

	    public int getMin() {
	        if ( mins.size () == 0 ) return -1;
	        return mins.get (mins.size() -1);
	    }


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
