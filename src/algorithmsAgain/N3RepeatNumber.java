package algorithmsAgain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times. 

 * @author mrincodi
 * 2016-09-17
 * Comment: Works, but there is no escape (or I don't see it) to having the possible last 2 elements
 * counted for in the array.
 * To understand the mechanism, see 
 * http://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
 */
public class N3RepeatNumber {

	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
		//if ( a.size () < 3 ) return -1;

		int numTimesNeededOriginal = a.size() / 3;
		//int numTimesNeeded = numTimesNeededOriginal;

		int candidate1 = -1;
		int numTimes1 = 0;
		int candidate2 = -1;
		int numTimes2 = 0;

		int i = 0;
		while ( i < a.size()){	  

			int num = a.get(i);

			if ( numTimes1 == 0 && numTimes2 == 0) {
				candidate1 = num;
				numTimes1 = 1;
			}

			else if ( numTimes1 == 0 && numTimes2 != 0 ){
				if ( candidate2 != num ){
					candidate1 = num;
					numTimes1=1;
				}
				else {
					numTimes2++;
				}
			}

			else if ( numTimes1 != 0 && numTimes2 == 0 ){
				if ( candidate1 != num ){
					candidate2 = num;
					numTimes2 = 1;
				}
				else
					numTimes1++;
			}

			else if ( numTimes1 != 0 && numTimes2 != 0 ){
				if ( candidate1 == num ){
					numTimes1++;
				}
				else if ( candidate2 == num ){
					numTimes2++;
				}
				else {
					//Three different numbers! Reduce the counters!
					numTimes1--;
					numTimes2--;
					//numTimesNeeded--;
				}
			}


			i++;
		}

		//Now, let's see which candidates are left.
		int count = 0;
		if ( numTimes1 > 0){
			for (  i = 0; i < a.size(); i++ ){
				if ( a.get(i)==candidate1 ) count++;
			}
			if ( count > numTimesNeededOriginal ) return candidate1;
		}

		count = 0;
		if ( numTimes2 > 0){
			for (  i = 0; i < a.size(); i++ ){
				if ( a.get(i)==candidate2 ) count++;
			}
			if ( count > numTimesNeededOriginal ) return candidate2;
		}

		return -1;
	}




	public static void main(String[] args) {
		ArrayList <Integer> a = new ArrayList <Integer> ( Arrays.asList(1000545, 1000038, 1000647, 1000038, 1000562, 1000038, 1000586, 1000487, 1000951, 1000226, 1000038, 1000145, 1000038, 1000761, 1000196, 1000038, 1000821, 1000829, 1000038, 1000570, 1000846, 1000038, 1000178, 1001000, 1000038, 1000568, 1000278, 1000734, 1000048, 1000038, 1000002, 1000271, 1000388, 1000315, 1000816, 1000038, 1000038, 1000846, 1000305, 1000853, 1000383, 1000116, 1000797, 1000279, 1000038, 1000038, 1000049, 1000108, 1000789, 1000240, 1000201, 1000506, 1000429, 1000857, 1000649, 1000898, 1000211, 1000000, 1000178, 1000038, 1000569, 1000695, 1000451, 1000159, 1000038, 1000038, 1000038, 1000129, 1000038, 1000038, 1000904, 1000038, 1000038, 1000902, 1000525, 1000038, 1000166, 1000038, 1000765, 1000038, 1000561, 1000417, 1000523, 1000668, 1000296, 1000038, 1000038, 1000038, 1000461, 1000654, 1000924, 1000985, 1000038, 1000426, 1000038, 1000038, 1000038, 1000904, 1000775, 1000148, 1000961, 1000038, 1000038, 1000038, 1000833, 1000332, 1000038, 1000038, 1000512, 1000322, 1000592, 1000524, 1000788, 1000057, 1000497, 1000625, 1000599, 1000484, 1000038, 1000747, 1000457, 1000111, 1000038, 1000038, 1000493, 1000287, 1000007, 1000695, 1000344, 1000098, 1000038, 1000191, 1000038, 1000576, 1000481, 1000488, 1000199, 1000038, 1000663, 1000176, 1000038, 1000521, 1000721, 1000728, 1000247, 1000038, 1000038, 1000460, 1000644, 1000038, 1000497, 1000966, 1000431, 1000038, 1000975, 1000063, 1000580, 1000669, 1000038, 1000038, 1000492, 1000038, 1000038, 1000529, 1000553, 1000333, 1000038, 1000341, 1000569, 1000862, 1000017, 1000532, 1000571, 1000508, 1000402, 1000285, 1000611, 1000210, 1000646, 1000110, 1000038, 1000553, 1000273, 1000729, 1000038, 1000038, 1000720, 1000400, 1000038, 1000983, 1000038, 1000766, 1000038, 1000180, 1000494, 1000765, 1000136, 1000038, 1000029, 1000246, 1000991, 1000038, 1000759, 1000038, 1000038, 1000045, 1000038, 1000648, 1000038, 1000038, 1000694, 1000914, 1000990, 1000038, 1000038, 1000758, 1000435, 1000038, 1000554, 1000038, 1000452, 1000156, 1000038, 1000322, 1000828, 1000868, 1000038, 1000973, 1000991, 1000464, 1000294, 1000633, 1000038, 1000582, 1000229, 1000285, 1000038, 1000038, 1000086, 1000038, 1000989, 1000038, 1000038, 1000157, 1000307, 1000369, 1000300, 1000038, 1000038, 1000038, 1000244, 1000038, 1000038, 1000222, 1000458, 1000038, 1000523, 1000434, 1000316, 1000038, 1000256, 1000038, 1000695, 1000038, 1000469 ));

		Integer [] array = { 1, 1, 1 };

		a = new ArrayList <Integer> ( Arrays.asList( array ));
		int n = new N3RepeatNumber().repeatedNumber(a);

		System.out.println (n);
	}

}
