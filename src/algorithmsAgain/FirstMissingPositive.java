package algorithmsAgain;

/**
 * Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.


To simply solve this problem, search all positive integers, starting from 1 in the given array. We may have to search at most n+1 numbers in the given array. So this solution takes O(n^2) in worst case.

We can use sorting to solve it in lesser time complexity. We can sort the array in O(nLogn) time.

Once the array is sorted, then a linear scan of the array is all that remains to be done.

So this approach takes O(nLogn + n) time which is O(nLogn).

We can also use hashing. We can build a hash table of all positive elements in the given array.

Once the hash table is built, all positive integers, starting from 1 can be searched here. As soon as we find a number which is not there in the hash table, we return it.

Approximately, this approach may take O(n) time, but it requires O(n) extra space.

But what we are really looking for is a O(n) time, O(1) space solution.

Note that ( N being the size of the array ), A[i]<=0 and A[i]>N are not the numbers you are looking for because the missing positive integer will be in the range [1, N+1].

The answer will be N+1 only if all of the elements of the array are exact one occurrence of [1, N].

If using extra space was an option, creating buckets would have been an easy solution.

Creating an array of size N initialized to 0, for every value A[i] which lies in the range [1, N], we would have incremented its count in the array. Consequently, we would traverse the array to find the first array position with value 0, hence finding our answer.

However, since we are not allowed buckets, can we use the existing array as bucket somehow?
 */
import java.util.ArrayList;

public class FirstMissingPositive {


	public int firstMissingPositive(ArrayList<Integer> a) {

		for ( int i = 0; i < a.size();i++){
			int index=i;
			int pos = i + 1;
			while (a.get(index)!=pos && a.get(index)>=1 &&a.get(index)<=a.size() && a.get(index) != a.get(a.get(index)-1)){
				//Swap a.get(index) with a.get(a.get(index)-1)
				int temp = a.get(index);
				a.set(index,a.get(a.get(index)-1));
				a.set(temp-1,temp);
			}
		}

		//Now, let's go over the array and let's find the first "wrong" integer.
		for ( int i = 0; i < a.size();i++){
			if (a.get(i) != i + 1) return i+1;
		}
		return a.size()+1;

	}


}
