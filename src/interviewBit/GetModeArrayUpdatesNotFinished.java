package interviewBit;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.PriorityQueue;
//import java.util.TreeMap;
//import java.util.TreeSet;
//
//

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
 * Comment: This was an incomplete attempt to solve the problem.
 * The idea is good: have a treeset that had as the key the frequencies
 * and as value a priority queue of the values with that frequency.
 * This would have work. Unfortunately, I don't have time for this today.
 */
public class GetModeArrayUpdatesNotFinished {
//
//	public ArrayList<Integer> getMode(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> b) {
//		ArrayList<Integer> result = new ArrayList<Integer> ();
//		if ( b.size() < 1 ) return result;
//
//		TreeMap <Integer, Integer> freqHM = new TreeMap <Integer, Integer> ();
//		TreeMap <Integer, PriorityQueue <Integer>> modeStruct = new TreeMap <Integer, PriorityQueue <Integer>>(Collections.reverseOrder());
//
//		//First iteration to create HashSets.
//		for ( int val: a){
//			if ( freqHM.containsKey ( val ))
//				freqHM.put ( val, freqHM.get(val)+1);
//			else 
//				freqHM.put ( val, 1);
//		}
//
//		//With freqHM I create modeStruct.
//		for ( Map.Entry<Integer, Integer> entry : freqHM.entrySet()){
//			int num = entry.getKey();
//			int times = entry.getValue();
//			
//			if (modeStruct.containsKey(times))
//				modeStruct.get(times).add(num);
//			else
//				modeStruct.put(times, new PriorityQueue<Integer>(Arrays.asList(num)));
//				
//		}
//		
//		//Now go over the changes array.
//		for ( ArrayList<Integer> change: b ){
//			int pos = change.get(0);
//			int oldValue = a.get(pos-1); //Index starts in 1.
//			int newValue = change.get(1);
//
//			if (oldValue == newValue && result.size() != 0 )
//				result.add (result.get (result.size()-1));
//			else {
//
//				//Change the frequency of the previous value:
//				a.set (pos-1, newValue);
//				
//				int oldFreq = freqHM.get(oldValue);
//				int newFreq = oldFreq - 1;
//				freqHM.put(oldValue, newFreq);
//
//				//Fix the priority queues in modeStruc.
//				modeStruct.get(oldFreq).remove(oldValue);
//				if (modeStruct.get(oldFreq).size()==0)
//					modeStruct.remove(oldFreq);
//				
//				if ( modeStruct.containsKey(newFreq))
//					modeStruct.get(newFreq).add(oldValue);
//				else
//					modeStruct.
//				
//				
//				//Now change the frequences in the new value.
//				
//				if ( freqHM.containsKey ( newValue)){
//					oldFreq = freqHM.get(newValue);
//					newFreq = oldFreq + 1;
//					freqHM.put(newValue, newFreq);
//				}
//				else{
//					oldFreq = -1;
//					newFreq = 1;
//					freqHM.put(newValue, newFreq);	
//				}
//
//				//Fix the priority queues in modeStruc.
//				
//				if ( oldFreq != -1){
//					//This number was previously in a priority queue.
//					modeStruct.get(oldFreq).remove(newValue);
//				}
//				//else: it wasn't in a priority queue, so don't worry.
//				
//				if ( )
//				
//				
//				//Now, calculate mode.
//				//TODO: Enhance this with a customized Comparator.
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				
//				Iterator <Integer> iter = freqHM.keySet().iterator();   
//
//				int currentMode =0;
//				int maxFreq=0;
//				while ( iter.hasNext() ){
//					int val =  iter.next();	//TODO: Check this.
//					int freq = freqHM.get(val);
//					if ( freq > maxFreq ){
//						maxFreq=freq;
//						currentMode=val;
//					}
//				}
//				result.add (currentMode);
//			}
//		}
//
//		return result;
//	}
//
//
//	public static void main ( String [] args ){
//		ArrayList<Integer> a = new ArrayList <Integer> ( Arrays.asList(2,2,2,3,3));
//
//		ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>> ();
//		b.add(new ArrayList<Integer>(Arrays.asList(1,3)));
//		b.add(new ArrayList<Integer>(Arrays.asList(5,4)));
//		b.add(new ArrayList<Integer>(Arrays.asList(2,4)));
//
//		ArrayList<Integer> modes = new FreqComp().getMode(a, b);
//		System.out.println(modes);
//	}
//
}
