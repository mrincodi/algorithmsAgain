package interviewBit;

/**
 * 
 * Given an array with non negative numbers, divide the array 
 * into two parts such that the average of both the parts is equal. 
Return both parts (If exist).
If there is no solution. return an empty list.

Example:


Input:
[1 7 15 29 11 9]

Output:
[9 15] [1 7 11 29]

The average of part is (15+9)/2 = 12,
average of second part elements is (1 + 7 + 11 + 29) / 4 = 12

 NOTE 1: If a solution exists, you should return a list of exactly 2 
 lists of integers A and B which follow the following condition :
* numElements in A <= numElements in B
* If numElements in A = numElements in B, then A is lexicographically 
* smaller than B ( https://en.wikipedia.org/wiki/Lexicographical_order ) 
* NOTE 2: If multiple solutions exist, return the solution where 
* length(A) is minimum. If there is still a tie, return the one where A
*  is lexicographically smallest. 
*  NOTE 3: Array will contain only non negative numbers. 
*  
*  
*  Hint:
*  Lets try to simplify the problem.

Lets assume the two sets are set1 and set2.

Assume sum of set1 = Sum_of_Set1, with size = size_of_set1. 
Assume sum of set2 = Sum_of_Set2, with size = size_of_set2


 SUM_of_Set1 / size_of_set1 = SUM_of_Set2 / size_of_set2
 SUM_of_Set1 = SUM_of_Set2 * (size_of_set1 / size_of_set2)
 
    total_sum = Sum_of_Set1 + Sum_of_Set2
    AND size_of_set2 = total_size - size_of_set1
 
  Sum_of_Set1 = (total_sum - Sum_of_Set1) * (size_of_set1 / (total_size - size_of_set1))
  OR on simplifying,
    
  total_sum / Sum_of_Set1 - 1 = (total_size - size_of_set1) / size_of_set1
  total_sum / Sum_of_Set1 = total_size / size_of_set1
  Sum_of_Set1 / size_of_set1 = total_sum / total_size
 

Note that you need the solution with minimum size_of_set1 if multiple solutions exist. 
So, just iterate on size_of_set1. 
Based on size_of_set1, you can determine the value of Sum_of_Set1. 
Now, the problem reduces to

Can I select size_of_set1 values from the array whose sum is Sum_of_Set1 ? 


Solution approach:
**Continue from hint **

In previous hint, we explored how we can break down the given problem into a much simpler problem

Can I select current_size values from the array whose sum is current_sum ? 
Lets define our function as 
isPossible(ind, current_sum, current_size) which returns true if it is possible to use elements with index >= ind to construct a set of size current_size whose sum is current_sum.


isPossible(ind, current_sum, current_size :            |
                                                       |
                                                       |  isPossible(ind + 1, current_sum, current_size)  [ Do not include current element ]
                                Or(|) Logical operator |
                                                       |
                                                       | 
                                                       |  
                                                       |  isPossible(ind + 1, current_sum - value_at(ind), current_size - 1)
                                                       |


Can you memoize values to reduce the time complexity of the above recursive function ?
*  
*  
*  
 * @author Mario
 * 2016-08-11
 * 
 * 
 * Comment: I'll be honest: I didn't do it. It is a very difficult question.
 * The hints are crucial.
 * Perhaps someday I'll do it. 
 * Complete solution from InterviewBit was not available.
 */
public class EqualAveragePartitionNeverDone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
