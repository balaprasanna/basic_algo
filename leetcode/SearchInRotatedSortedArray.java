//https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
//based on recursive binary search
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
        if(A == null || A.length == 0) return -1;
        return search(A, target, 0, A.length-1);
    }
    private int search(int[] A, int target, int lo, int hi){
        if(lo > hi) return -1;
        
        int mid = (lo + hi)/2;
        if(A[mid] ==  target) return mid;
        
        if(A[lo] <= A[mid]){
            if(target >= A[lo] && target < A[mid])
                return search(A, target, lo, mid-1);
            else
                return search(A, target, mid+1, hi);
        }else{
            if(target > A[mid] && target <= A[hi])
                return search(A, target, mid+1, hi);
            else
                return search(A, target, lo, mid-1);
        }
        
    }
}
