package Sorting;

import java.util.Random;

public class QuickSort {
	public void quickSort(int[] a, int p, int q){
		if(p<q){
			int r = partition(a, p, q);
			quickSort(a, p, r-1);
			quickSort(a, r+1, q);
		}
	}
	//randomized-version of quicksort
	public void randQuickSort(int[] a, int p, int q){
		if(p<q){
			int r = randomPartition(a, p, q);
			randQuickSort(a, p, r-1);
			randQuickSort(a, r+1,q);
		}
	}
	public int partition(int[] a, int p, int q){
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
	//partition using random sampling
	public int randomPartition(int[] a, int p, int q){
		Random rand = new Random();
		int r = rand.nextInt(q-p+1)+p;
		swap(a, r, q);
		return partition(a, p ,q);
	}
	public void swap(int[] a, int p, int q){
		if(p!=q){
			int tmp = a[p];
			a[p] = a[q];
			a[q] = tmp;
		}
	}
}
