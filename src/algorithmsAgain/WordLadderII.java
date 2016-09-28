package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;

//INCOMPLETE. Too long!!
public class WordLadderII {
//
//	public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
//
//		int startPos = 0;
//		int endPos = 0;
//
//		if ( !dict.contains(start)) 
//			dict.add(start);
//
//		if ( !dict.contains(end))			
//			dict.add(end);
//
//		startPos = dict.indexOf(start);
//		endPos = dict.indexOf(end);
//
//		int [] [] neighborMatrix = new int [dict.size()] [dict.size()];
//		//Let's do the matrix of neighbors.
//		for ( int i = 0; i < dict.size(); i++){
//			for ( int j = 0; j < dict.size(); j++ ){
//				if ( isNeighbor (dict.get(i), dict.get(j)))
//					neighborMatrix[i][j]=1;
//			}
//		}
//
//		//Now, create the arrayLists!
//
//		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>> ();
//
//		Queue <Integer> posQueue = new LinkedList <Integer>();
//
//		LinkedHashSet <Integer> usedPos = new LinkedHashSet <Integer> ();
//		posQueue.add(startPos);
//		result.add(new ArrayList <String> (Arrays.asList(start)));
//		usedPos.add(startPos);
//
//		while ( !posQueue.isEmpty()){
//			int thisWordPos = posQueue.remove();
//
//			//Now, get neighbors. Add them to a LinkedHashSet.
//			ArrayList <Integer> newNeighbors = new ArrayList <Integer> ();
//			for ( int i = 0; i < dict.size(); i++){
//				if ( neighborMatrix [thisWordPos][i] == 1){
//					//TODO this !posQueue.contains(i) could be enhanced with a HashSet that
//					// had the same elements as the queue.
//					if (!usedPos.contains(i) && !posQueue.contains(i)){
//						posQueue.add(i);
//						newNeighbors.add(i);
//					}
//
//					//Now, find all the arrayLists whose last element is i.
//					//TODO: This could be enhanced, perhaps with a HashMap.
//
//					ArrayList<ArrayList<String>> resultCopy = new ArrayList<ArrayList<String>>(result);
//					for ( ArrayList <String> aResult: resultCopy){
//						if ( aResult.get(aResult.size()-1) == dict.get (i)){
//							if ( newNeighbors.size() == 1){
//								aResult.add(dict.get (newNeighbors.get(0)));
//							}
//							else {
//								//Replace current entry with several entries that end in the new word.
//								
//								ArrayList <ArrayList <String>> newResults = new ArrayList <ArrayList <String>>();
//								for ( int newNeighbor : newNeighbors){
//									ArrayList <String> thisNewEntry = new ArrayList <String> (aResult);
//									thisNewEntry.add(dict.get(newNeighbor));
//									newResults.add(thisNewEntry);
//									
//								}
//
//						}
//					}
//
//				}
//			}
//
//		}
//	}
//
//	return null;
//}
//
//private boolean isNeighbor(String string, String string2) {
//
//	return false;
//}
//
//



}
