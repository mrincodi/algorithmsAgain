package interviewBit;

import java.util.ArrayList;

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
 * Comment: Works, but too slow for InterviewBit.
 */
public class AllocateBooks {


	public int books(ArrayList<Integer> p, int m) {

		if ( m > p.size() || m < 1 ) return -1;

		return books(p, m, 0);

	}

	public int books(ArrayList<Integer> p, int m, int startIndex) {

		if ( m == 1) {
			int result = 0;
			for ( int i = startIndex; i < p.size(); i++)
				result += p.get(i);

			return result;
		}

		int thisStudentPages = 0;
		int bestStudentPages = Integer.MAX_VALUE;
		for ( int i = startIndex; i < p.size() - m + 1; i++){
			thisStudentPages += p.get(i);
			int otherStudentMaxPages= books ( p, m - 1, i + 1);
			int thisMaxPages = Math.max (thisStudentPages, otherStudentMaxPages);
			bestStudentPages = Math.min (bestStudentPages, thisMaxPages);
		}
		return bestStudentPages;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
