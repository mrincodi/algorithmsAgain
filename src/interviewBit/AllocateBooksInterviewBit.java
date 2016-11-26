package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * N number of books are given. 
The ith book has Pi number of pages. 
You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

NOTE: Return -1 if a valid assignment is not possible

Input:
 List of Books M number of students 

Your function should return an integer corresponding to the minimum number.

Example:

P : [12, 34, 67, 90]
M : 2

Output : 113

There are 2 number of students. Books can be distributed in following fashion : 
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113. 

 * @author mrincodi
 * 2016-10-13
 * Comment: Incredibly, this naïve solution is much better than mine.
 */
public class AllocateBooksInterviewBit {

	public int books(ArrayList<Integer> A, int B) {

		int students = B;
		long high = Long.MAX_VALUE;
		long low = 0;
		long mid, res = 0;

		if (B > A.size())
			return -1;

		long sum = 0;

		for (int pages : A)
			sum += pages;

		while (low <= high) {

			mid = low + ((high - low) >> 1);

			if (isPossible(A, B, mid, sum)) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return (int) res;

	}

	private boolean isPossible(ArrayList<Integer> A, int B, long maxPage, long totalPages) {

		if (maxPage < totalPages / B)
			return false;

		int index = 0;
		int n = A.size();
		int i;

		for (i = 0; i < B && index < n; i++) {
			long page = maxPage;
			long total = 0;

			while (total < maxPage && index < n) {
				total += A.get(index);
				if (total > maxPage)
					break;
				index++;
			}
		}

		if (index < n)
			return false;

		return true;
	}


	public static void main(String[] args) {
		ArrayList <Integer> A = new ArrayList <Integer> ( Arrays.asList(12, 34, 67, 90));
		int B = 2;
		int pages = new AllocateBooksInterviewBit().books(A, B);
		System.out.println(pages);
		// TODO Auto-generated method stub

	}

}
