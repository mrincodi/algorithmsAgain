package interviewBit;

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
 * Comment: This doesn't work.
 */
public class GasStationWrong {

	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {

		//Let's try brute force.
		int howManyStations = gas.size();

		int totalSumGas =0;
		int totalSumCost = 0;
		for ( int i = 0; i < howManyStations; i++){
			totalSumGas  += gas.get (i);
			totalSumCost += cost.get(i);
		}
		if ( totalSumCost > totalSumGas ) return -1;

		if (howManyStations <= 1) return 0;

		int startingStation = 0;
		//for ( int startingStation = 0; startingStation < howManyStations; startingStation++ ){
		while (startingStation < howManyStations){
			int currentStation = startingStation;
			int numStationsVisited = 0;
			int energyLeft=0;
			boolean outOfGas=false;
			if (gas.get(startingStation) == 0) outOfGas=true;

			while (numStationsVisited < howManyStations && !outOfGas){
				energyLeft += gas.get(currentStation);
				if (energyLeft-cost.get(currentStation) < 0 ){
					outOfGas = true;
					startingStation=currentStation + 1;
				}
				else {
					energyLeft = energyLeft-cost.get(currentStation);
					currentStation=(currentStation+1)%howManyStations;
					howManyStations++;
				} 
			}
			if (!outOfGas) return startingStation;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
