package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * 
 * You are given an array of N positive integers, A1, A2 ,…, AN. 
Also, given a Q updates of form:
- i j: Update Ai = j. 1 ≤ i ≤ N.

Perform all updates and after each such update report mode of the array. Therefore, return an array of Q elements, where ith element is mode of the array after ith update has been executed.

Notes 
- Mode is the most frequently occuring element on the array.
- If multiple modes are possible, return the smallest one.
- Update array input is via a Q*2 array, where each row represents a update.

For example,

A=[2, 2, 2, 3, 3]

Updates=    [ [1, 3] ]
            [ [5, 4] ]
            [ [2, 4] ]

A = [3, 2, 2, 3, 3] after 1st update.
3 is mode.

A = [3, 2, 2, 3, 4] after 2nd update.
2 and 3 both are mode. Return smaller i.e. 2.

A = [3, 4, 2, 3, 4] after 3rd update.
3 and 4 both are mode. Return smaller i.e. 3.

Return array [3, 2, 3].
Constraints 
1 ≤ N, Q ≤ 105 
1 ≤ j, Ai ≤ 109


 * @author mrincodi
 * 2016-08-29
 * Comment: Worked but took too long for InterviewBit.
 */
public class GetModeArrayUpdates {

	public ArrayList<Integer> getMode(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> b) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if ( b.size() < 1 ) return result;

		TreeMap <Integer, Integer> freqHM = new TreeMap <Integer, Integer> ();

		//First iteration to create HashSet.
		for ( int val: a){
			if ( freqHM.containsKey ( val ))
				freqHM.put ( val, freqHM.get(val)+1);
			else 
				freqHM.put ( val, 1);
		}

		//Now go over the changes array.

		for ( ArrayList<Integer> change: b ){
			int pos = change.get(0);
			int oldValue = a.get(pos-1); //Index starts in 1.
			int newValue = change.get(1);

			if (oldValue == newValue && result.size() != 0 )
				result.add (result.get (result.size()-1));
			else {
				//Fix numbers. Then get mode.
				a.set (pos-1, newValue);
				freqHM.put(oldValue, freqHM.get(oldValue)-1);
				if ( freqHM.containsKey ( newValue))
					freqHM.put(newValue, freqHM.get(newValue)+1);
				else
					freqHM.put(newValue, 1);

				//Now, calculate mode.
				//TODO: Enhance this with a customized Comparator.
				Iterator <Integer> iter = freqHM.keySet().iterator();   

				int currentMode =0;
				int maxFreq=0;
				while ( iter.hasNext() ){
					int val =  iter.next();	//TODO: Check this.
					int freq = freqHM.get(val);
					if ( freq > maxFreq ){
						maxFreq=freq;
						currentMode=val;
					}
				}
				result.add (currentMode);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		ArrayList <Integer> a = new ArrayList <Integer> ( Arrays.asList(1));
		ArrayList <ArrayList <Integer>> b = new ArrayList <ArrayList <Integer>> ();
		b.add(new ArrayList<Integer> ( Arrays.asList(1,1)));
		
		ArrayList <Integer> res = new GetModeArrayUpdates().getMode(a, b);
		
		for ( int v : res){
			System.out.println(v);
		}

	}

}
