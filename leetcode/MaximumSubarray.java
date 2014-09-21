
public class MaximumSubarray {
	public int maxSubArray(int[] A) {
        if(A == null || A.length == 0) return Integer.MIN_VALUE;
        int max = A[0];
        int presum = A[0];
        for(int i = 1; i < A.length; i++)
        {
            if(presum <= 0)
                presum = A[i];
            else
                presum += A[i];
            max = Math.max(max, presum);
        }
        return max;
    }
	//follow up, solve in a divide & conquer approach
	public int maxSubArray2(int[] A) {
        if(A == null || A.length == 0) return Integer.MIN_VALUE;
        return divideAndConquer(A, 0, A.length-1);
    }
    private int divideAndConquer(int[] A, int left, int right){
        if(left == right) return A[left];
        int mid = (left+right)/2;
        int leftans = divideAndConquer(A, left, mid);
        int rightans = divideAndConquer(A, mid+1, right);
        int leftmax = A[mid];
        int rightmax = A[mid+1];
        int tmp = 0;
        for(int i = mid; i>=left; i--){
            tmp += A[i];
            if(tmp > leftmax) leftmax = tmp;
        }
        tmp = 0;
        for(int i = mid+1; i<=right; i++){
            tmp+= A[i];
            if(tmp > rightmax) rightmax = tmp;
        }
        return Math.max(Math.max(leftans, rightans), leftmax+rightmax);
    }
}
