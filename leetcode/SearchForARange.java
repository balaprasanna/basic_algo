//https://oj.leetcode.com/problems/search-for-a-range/
//variant of binary search
public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
        int[] ind = {-1, -1}; //ind[0]: left, ind[1]: right
        if(A == null || A.length  == 0) return ind;
        search(A, target, 0, A.length-1, ind);
        return ind;
    }
    private void search(int[] A, int target, int lo, int hi, int[] ind){
        if(lo > hi) return;
        int mid = (lo + hi)/2;
        if(A[mid] == target){
            if(ind[0] == -1) ind[0] = mid;
            if(ind[1] == -1) ind[1] = mid;
            if(mid < ind[0]) ind[0] = mid;
            if(mid > ind[1]) ind[1] = mid;
        }
        if(mid >0 && target <=A[mid-1]){
            search(A, target, lo, mid-1, ind);
        }
        if(mid+1 <A.length && target >=A[mid+1] ){
            search(A, target, mid+1, hi,ind);
        }
        return;
    }
}
