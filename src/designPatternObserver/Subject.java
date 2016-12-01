package designPatternObserver;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private List < Observer > observers = new ArrayList <Observer>();
	private int state;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void notifyAllObservers(){
		for (Observer o: observers){
			o.update();
			
		}
	}
	
	public void attach (Observer o){
		observers.add(o);
	}
}
