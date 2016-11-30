package gExtraInterview1;

import java.util.List;

interface Workflow<Step> {

	public List<Step> getSteps();  // [A, B, C, D, E, F]

	public void addStep(Step s) throws DuplicateStepException;
	public void removeStep(Step s) throws NoSuchStepException, ExistingDepsException;




	//                 B       -> C
	public void addDep(Step from, Step to) throws NoSuchStepException;
	//                    B       -> C
	public void removeDep(Step from, Step to) throws NoSuchStepException;




	//                              B      -> true
	public boolean hasIncomingSteps(Step s) throws NoSuchStepException;
	//                                 B       = [A]
	public List<Step> getIncomingSteps(Step s) throws NoSuchStepException;
	//                              B       = true
	public boolean hasOutgoingSteps(Step s) throws NoSuchStepException;
	//                                 B       = [C, D]
	public List<Step> getOutgoingSteps(Step s) throws NoSuchStepException;




	public int countDependencies();   // 3
}