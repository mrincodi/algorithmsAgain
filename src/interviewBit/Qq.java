package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Qq {
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		return findMedianSortedArrays(a, b, 0, a.size());
	}
	
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b, int imin, int imax) {
		int m = a.size();
		int n = b.size();
		
		int i = (imin + imax) / 2;
		int j = ((m + n + 1) / 2) - i;
		
		if (b.get(j-1)>a.get(i)){
			return findMedianSortedArrays (a,b,i+1,imax);
		}
		else if ( a.get(i-1)>b.get(j)){
			return findMedianSortedArrays (a,b,imin,i-1);
		}
		else {
			if ( ( m+n)%2==1){
				return Math.max(a.get(i - 1), b.get(j - 1));
			}
			else {
				return ( Math.max(a.get(i - 1), b.get(j - 1)) + Math.min(a.get(i ), b.get(j ))/2);
			}
		}
	}
	
//	Search in [imin, imax]:
//	    i = (imin + imax) / 2
//	    j = ((m + n + 1) / 2) - i
//	    if B[j - 1] > A[i]: 
//	        search in [i + 1, imax]
//	    else if A[i - 1] > B[j]: 
//	        search in [imin, i - 1]
//	    else:
//	        if m + n is odd:
//	            answer is max(A[i - 1], B[j - 1])
//	        else:
//	            answer is (max(A[i - 1], B[j - 1]) + min(A[i], B[j])) / 2
//	            
	            
	public static void main(String[] args) {
//		List <Integer> a = new ArrayList <Integer> (Arrays.asList(3,5,6,7,93,99));
//		List <Integer> b = new ArrayList <Integer> (Arrays.asList(1,4,8,104,124,134));
		List <Integer> a = new ArrayList <Integer> (Arrays.asList(1,5,9));
		List <Integer> b = new ArrayList <Integer> (Arrays.asList(2,4));
		
		double d = new Qq ().findMedianSortedArrays (a,b);
		
		System.out.println(d);
		

	}

}
