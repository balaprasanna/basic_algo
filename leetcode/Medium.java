//leetcode medium of 2 sorted arrays
public class Medium {
	public static double findMedianSortedArrays(int A[], int B[])  {
        int m = A.length, n = B.length;
        if ( (m+n) % 2 == 1) //total length is odd
            return findKth(A, m, B, n, ((m+n)>>1) + 1);
        else //total length is even
            //return (findKth(A, m, B, n, (m+n)>>1) + findKth(A, m, B, n, ((m+n)>>1) + 1))/2.0;
        {
        	double r1 = findKth(A, m, B, n, (m+n)>>1);
        	double r2 = findKth(A, m, B, n, ((m+n)>>1) + 1);
        	return (r1+r2)/2.0;
        }
    }
    //auxiliary function in recursion
    //find the Kth largest number
    public static double findKth(int A[], int m, int B[], int n, int k){
        if (m == 0)
            return (double)B[B.length - n + k -1];
        if (n == 0)
            return (double)A[A.length -m + k -1];
        if (k == 1)
            return (double)((A[A.length -m] > B[B.length -n])? B[B.length -n] : A[A.length - m]);
        int len = k >> 1;
       	int i,j;
        if (len > m) i = A.length -1;
        else i = A.length - m + len-1;
        if (len > n) j = B.length -1;
        else j = B.length -n + len -1;
        if (A[i] > B[j])
        	return findKth(A, m, B, B.length-1-j, k-(n-B.length+1+j));
        else
        	return findKth(A, A.length-1-i, B, n, k-(m-A.length+1+i));     
    } 
    
    public static void main(String[] args){
    	int[] A = {1};
    	int[] B = {2,3,4,5,6};
    	System.out.print(findMedianSortedArrays(A,B));
    }
}
