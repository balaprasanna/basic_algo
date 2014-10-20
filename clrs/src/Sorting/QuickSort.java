package Sorting;

import java.util.Random;

public class QuickSort {
	public static void quickSort(int[] a, int p, int q){
		if(p<q){
			int r = partition(a, p, q);
			quickSort(a, p, r-1);
			quickSort(a, r+1, q);
		}
	}
	public static int partition(int[] a, int p, int q){
		int i = p-1;
		int key = a[q]; //deterministic choice of pivot
		for(int j = p; j<q; j++)
			if(a[j]<key){
				i++;
				swap(a, i, j);
			}
		swap(a, i+1, q);
		return i+1;
	}
	//randomized-version of quicksort ================================
	public static void randQuickSort(int[] a, int p, int q){
		if(p<q){
			int r = randomPartition(a, p, q);
			randQuickSort(a, p, r-1);
			randQuickSort(a, r+1,q);
		}
	}
	//partition using random sampling
	public static int randomPartition(int[] a, int p, int q){
		Random rand = new Random();
		int r = rand.nextInt(q-p+1)+p;
		swap(a, r, q);
		return partition(a, p ,q);
	}
	
	//modified version for dealing with douplicates ============================
	public static void pQuickSort(int[] a, int p, int q){
		if(p<q){
			int[] result = ppartition(a, p , q);
			pQuickSort(a, p, result[0]-1);
			pQuickSort(a, result[1]+1, q);
		}
	}
	//modification to be more efficient when douplicates exist
	public static int[] ppartition(int[] a, int p, int q){
		int key = a[q];
		int i = p-1; //for smaller 
		int j = p-1; //for equal
		for(int k = p; k < q; k++)
			if(a[k] == key){
				j++;
				swap(a, j, k);
			}else if(a[k] < key){
				j++;
				swap(a, j , k);
				i++;
				swap(a, i ,j);
			}
		swap(a, j+1, q);
		//pay attention to the technique to return more than one variable
		return new int[] {i+1, j+1};
	}
	
	//auxiliary functions and testing======================================
	public static void swap(int[] a, int p, int q){
		if(p!=q){
			int tmp = a[p];
			a[p] = a[q];
			a[q] = tmp;
		}
	}
	public static void main(String[] args){
        int[] test = {2,6,5,3,8,1,3,5,5,5,};
        //quickSort(test,0,test.length-1);
        //randQuickSort(test, 0, test.length-1);
        pQuickSort(test,0,test.length-1);
        for(int item: test)
            System.out.println(item);
    }
}
