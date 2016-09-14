package topcoder;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * Problem Statement
Fox Ciel and Fox Jiro just found a box of jewelry. There are n pieces of jewelry in the box. The pieces are numbered 0 through n-1. You are given a x with n elements. For each i, the value of piece i is x[i]. 

Ciel and Jiro want to divide the jewelry in a fair way. Each fox must take a non-empty subset of the jewelry. Obviously, the two subsets must be disjoint: each piece of jewelry can only be taken by at most one fox. The total value of jewelry taken by Ciel must be exactly the same as the total value of jewelry taken by Jiro. 

If there is no valid solution, return an empty . If there are multiple valid solutions, you may choose any of them. Return a res with n elements. For each i:
res[i]=1 denotes that Ciel should take the piece number i
res[i]=-1 denotes that Jiro should take the piece number i
res[i]=0 denotes that piece number i should be left in the box
Definition
Class: DivideJewelry
Method: divide
Parameters: int[]
Returns: int[]
Method signature: int[] divide(int[] x)
(be sure your method is public)
Limits
Time limit (s): 2.000
Memory limit (MB): 256
Constraints
- x will contain between 2 and 1,000 elements, inclusive.
- Each element in x will be between 1 and 1,000,000, inclusive.
Examples
0)
{1,2,3}
Returns: {1, 1, -1 }
One fox should take pieces 0 and 1, and the other fox should take piece 2. The total value of jewelry taken by each fox will be 3. You may return either {1, 1, -1} or {-1, -1, 1}.
1)
{1,2}
Returns: { }
It is impossible to divide these two pieces evenly. Note that each fox must take at least one piece of jewelry.
2)
{1,1,2,4,8,16,32}
Returns: {1, -1, 0, 0, 0, 0, 0 }
Here, one easy solution is that one fox takes piece 0 and the other fox takes piece 1. This is a fair division because both pieces have the same value.
3)
{1,2,4,8,16,32}
Returns: { }
4)
{534,260,643,230,450,560,430,210}
Returns: {0, 0, 0, 1, -1, 0, 1, -1 }
 * @author Mario
 * 2016-09-12
 * Comment: Good news: works. Bad news: Seems it takes too long for TopCoder.
 *
 */
public class DivideJewelry {
	public int[] divide(int[] x){
		int [] result = new int [x.length];
		TreeMap <Integer, ArrayList <Integer>> h = new TreeMap <Integer, ArrayList <Integer>>();
		for ( int i = 0; i < x.length; i++ ){
			int val = x[i];
			if ( h.containsKey (val)){

				for ( int oldPos:h.get(val)){
					result [oldPos]=1;
				}
				result[i]=-1;
				return result;
			}

			Set <Integer> keys = new HashSet <Integer> (h.keySet());
			Iterator <Integer> iter = keys.iterator();

			while ( iter.hasNext() ){
				int key = iter.next();
				ArrayList <Integer> values = h.get(key);

				int newKey = key + val;
				ArrayList <Integer> newValues = new ArrayList <Integer> (values);
				newValues.add (i);

				if ( h.containsKey (newKey) ){
					//Found!
					for ( int pos:h.get(newKey))
						result[pos]=1;

					for ( int pos:newValues){
						if ( h.get(newKey).contains(pos))
							result[pos]=0;
						else
							result[pos]=-1;
					}

					return result;
				}
				else
					h.put (newKey, newValues);
			}

			h.put (val, new ArrayList <Integer>(Arrays.asList(i)));

		}    
		int [] result2 = new int[0];
		return result2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array = 							{2048, 2, 32768, 8, 256, 64, 65536, 262144, 16, 8192, 32, 131072, 524287, 4096, 1, 4, 1024, 16384, 128, 512};
		int [] result = new DivideJewelry().divide(array);

		for ( int val:result){ System.out.print(val + " "); }

		System.out.println();
		int total = 0;
		for ( int i = 0; i < result.length; i++){ 
			int num = array[i] * result [ i ];
			if (num != 0) System.out.print(num + " "); 
			total += num;
		}
		System.out.println();
		System.out.println(total);

	}
}




