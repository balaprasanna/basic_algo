
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
        //注意从后往前搬，不然会写掉后面的数
		for(int i = m-1; i >=0; i--)
            A[n+i] = A[i];
        int a = n;
        int b = 0;
        for(int i = 0; i < m+n; i++){
            if(a>= m+n )
                A[i] = B[b++];
            else if(b>=n)
                A[i] = A[a++];
            else if(A[a] < B[b])
                    A[i] = A[a++];
            else
                A[i] = B[b++];
        }
    }
}
