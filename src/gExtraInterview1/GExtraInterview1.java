package gExtraInterview1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class GExtraInterview1 {

	//TODO: This only work for acyclical graphs.
	public static List<Step> sort(Workflow<Step> w) throws Exception {

		HashSet<Step> visited = new HashSet<Step> ();
		Stack <Step> responseStack = new Stack <Step>();
		ArrayList<Step> response = new  ArrayList<Step> ();

		for (Step s: w.getSteps())
			if (!visited.contains(s))
				sortUtil (w, s, visited, responseStack);

		while (!responseStack.isEmpty()){
			response.add(responseStack.pop());
		}

		return response;

	}

	/**
	 * Recursive method.
	 * TODO: This only works for acyclic graphs.
	 * 
	 * @param s
	 * @param visited
	 * @param responseStack
	 */
	private static void sortUtil(Workflow<Step> w, Step s, HashSet<Step> visited, Stack<Step> responseStack) {
		visited.add(s);
		
		try {
			for ( Step nextStep : w.getOutgoingSteps(s)){
				if (!visited.contains(nextStep)){
					sortUtil(w,nextStep,visited,responseStack);
				}
			}
		} catch (NoSuchStepException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//_Last thing_ is to add this step to the stack.
		responseStack.push(s);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
