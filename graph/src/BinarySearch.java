//This is not a graph algorithm, but I will put it here for the time being
//implementation of binary search in a recursive way
public class BinarySearch {
	public int search(int key, int[]a ){
		return search(key, a, 0, a.length-1);
	}
	public int search(int key, int[]a, int low, int high){
		int mid = (low+high)/2;
		if(a[mid] == key) 
			return mid;
		else if(a[mid] < key)
			return search(key, a, mid+1, high);
		else
			return search(key, a, low, mid-1);
	}
}
