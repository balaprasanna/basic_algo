//https://oj.leetcode.com/problems/search-insert-position/
//crazy easy twist
//need reviewing
public class SearchInsertPosition {
	private static int pos;
    public static int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0) return 0;
        pos = A.length;
        search(A, target, 0, A.length-1);
        if(A[pos] >= target) return pos;
        else return pos+1;
    }
    private static void search(int[] A, int target, int lo, int hi){
        if(lo > hi) {pos = lo; return;}
        if(lo == hi){
        	if(A[lo]< target) {pos = lo+1; return;}
        	if(A[lo] >= target){pos = lo; return;}
        }
        int mid = (lo + hi)/2;
        if(A[mid] == target) {pos = mid; return;}
        else if(target > A[mid])
            search(A, target, mid+1, hi);
        else
            search(A, target, lo, mid-1);
    }
    public static void main(String[] args){
    	int[] A={1,3};
    	int target = 0;
    	System.out.print(searchInsert(A, target));
    }
}
