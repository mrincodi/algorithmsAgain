package algorithmsAgain;

import java.util.List;

/**
 * 
 * There are N gas stations along a circular route, where the amount of gas at station i 
 * is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from 
station i to its next station (i+1). You begin the journey with an empty tank at one 
of the gas stations.

Return the minimum starting gas station’s index if you can travel around the circuit 
once, otherwise return -1.

You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2..
Completing the circuit means starting at i and ending up at i again.

Example :

Input :
      Gas :   [1, 2]
      Cost :  [2, 1]

Output : 1 

If you start from index 0, you can fill in gas[0] = 1 amount of gas. Now your tank 
has 1 unit of gas. But you need cost[0] = 2 gas to travel to station 1. 
If you start from index 1, you can fill in gas[1] = 2 amount of gas. Now your tank 
has 2 units of gas. You need cost[1] = 1 gas to get to station 0. So, you travel to 
station 0 and still have 1 unit of gas left over. You fill in gas[0] = 1 unit of 
additional gas, making your current gas = 2. It costs you cost[0] = 2 to get to 
station 1, which you do and complete the circuit. 

 * @author mrincodi
 * Comment: InterviewBit's solution. TODO: Understand.
 */
public class GasStation {

	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {

		int n;
		int petrol = 0;
		int i;
		int min = 0;
		int temp = 0;
		int lastPos = 0;

		n = gas.size();

		for (i = 0; i < n; i++) {
			petrol += gas.get(i);
			petrol -= cost.get(i);

			lastPos = Math.max(petrol, gas.get(i) - cost.get(i) + lastPos);

			if (lastPos >= 0) {
				if (min == -1)
					min = i;
			} else {
				min = -1;
			}

			lastPos = Math.max(0, lastPos);

		}

		if (petrol < 0)
			return -1;


		return min;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
