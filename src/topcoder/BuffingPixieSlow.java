package topcoder;

import java.util.HashMap;

/**
 * Problem Statement
    	
You are playing a turn-based role-playing game. At the moment you are preparing a strategy that will defeat an enemy character in the fewest turns possible. At the beginning of the fight the enemy has HP hitpoints. The enemy dies when their hitpoints become zero or negative.



A less experienced player may simply try attacking each turn, but you know the importance of support skills. In each of your turns you may choose one of the following two actions: either Focus or Attack.

Focus changes the amount of damage dealt by an Attack performed during your next turn.
Attack deals some damage to the opponent. If you used Focus during your immediately previous turn, the attack decreases the enemy's hitpoints by buffedAttack. Otherwise, the attack decreases the enemy's hitpoints by normalAttack.


You are given the ints HP, normalAttack and buffedAttack. Return the smallest number of turns in which you can kill the enemy.

 
Definition
    	
Class:	BuffingPixie
Method:	fastestVictory
Parameters:	int, int, int
Returns:	int
Method signature:	int fastestVictory(int HP, int normalAttack, int buffedAttack)
(be sure your method is public)
    
 
Constraints
-	HP will be between 1 and 10^9, inclusive.
-	normalAttack will be between 1 and 10^9, inclusive.
-	buffedAttack will be between 1 and 10^9, inclusive.
 
Examples
0)	
    	
5
1
3
Returns: 4
One optimal strategy looks as follows:
Turn 1: Focus.
Turn 2: Attack. Our enemy's hitpoints decrease from 5 to 2.
Turn 3: Focus.
Turn 4: Attack. Our enemy's hitpoints decrease from 2 to -1.
1)	
    	
10
20
50
Returns: 1
You can win by simply attacking on the first turn.
2)	
    	
24
2
5
Returns: 10
3)	
    	
497
40
45
Returns: 13
4)	
    	
8400
1
5
Returns: 3360
5)	
    	
10
2
1
Returns: 5
Note that buffedAttack does not have to be greater than normalAttack.

 * @author mrincodi
 * 2016-09-08
 * Comment: Perfect example of a problem that can be solved without DP or 
 * recursion, just by thinking a bit before coding.
 * This solution works, but is unnecessarily slow.
 * Conclusion: Think of a greedy approach first.
 *
 */
public class BuffingPixieSlow {

	HashMap <Integer, Integer> savedMinimums = new HashMap <Integer, Integer> ();

	int fastestVictory(int HP, int normalAttack, int buffedAttack){

		return fastestVictory( HP,  normalAttack,  buffedAttack, false);
	}

	private int fastestVictory(int HP, int normalAttack, int buffedAttack, boolean focus) {

		if (HP <= 0 ) return 0;
		
		int minNormal=0;
		int minBuffed = 0;
		int min = 0;

		if ( !focus){
			if ( savedMinimums.containsKey (HP) ) return savedMinimums.get (HP);

			minNormal = fastestVictory(HP - normalAttack, normalAttack, buffedAttack, false);
			minBuffed = fastestVictory(HP, normalAttack, buffedAttack, true);

			min = 1 + Math.min (minNormal, minBuffed);
			
			savedMinimums.put(HP, min);
		}
		else {
			if ( savedMinimums.containsKey (-1 * HP )) return savedMinimums.get (-1 * HP);
		
			min = 1 + fastestVictory(HP - buffedAttack, normalAttack, buffedAttack, false);

			savedMinimums.put(-1 * HP, min);
		}
		//		savedMinimums.put ( HP, min);
		return min;
	}

	public static void main(String[] args) {
		int num = new BuffingPixieSlow().fastestVictory(8400,1,5);
		System.out.println(num);
	}

}
