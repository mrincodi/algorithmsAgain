package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0’s) or contain magic orbs that increase the knight’s health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight’s minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path

RIGHT-> RIGHT -> DOWN -> DOWN.

 * @author mrincodi
 * 2016-12-12
 * Comment: This is InterviewBit's answer.
 */
public class DungeonPrincessInterviewBit {

	    
	    int dp[][];
	    ArrayList<ArrayList<Integer>> A;
	    int m, n;
	    
		public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
		    
		    if (A == null)
		        return 0;
		        
		    m = A.size();
		    n = A.get(0).size();
		    
		    dp = new int[m][n];
		    this.A = A;
		    
		    for (int i = 0; i < m; i++)
		        Arrays.fill(dp[i], -1);
		    
		    rec(0, 0);
		    
//		    if (dp[0][0] < 0)
//		        return -dp[0][0] + 1;

	        if (dp[0][0] <= 0)
	            return 1;
		    
		    return dp[0][0];
		}
		
		
		public int rec(int row, int col) {
		    
		    if (row == m - 1 && col == n - 1) {
		        int num = A.get(row).get(col);
		        if (num < 0)
		            return 1 - num;
		        else
		            return 1;
		    }
		    
		    if (dp[row][col] != -1)
		        return dp[row][col];
		    
		    int max = Integer.MAX_VALUE;
		    int num = A.get(row).get(col);
		    
		    if (isValid(row + 1, col)) {
		        max = rec(row + 1, col);
		        max -= num;
		        max = Math.max(1, max);
		    }
		        
		    if (isValid(row, col + 1)) {
		        int temp = rec(row, col + 1);
		        temp -= num;
	            temp = Math.max(1, temp);
	        
		        max = Math.min(temp, max);
		    }
		        
		    
		    return dp[row][col] = max;
		}
		
		
		public boolean isValid(int row, int col) {
		    if (row < 0 || row >= m || col < 0 || col >= n)
		        return false;
		        
		    return true;
		}
		
		

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
