package Sorting;

public class HeapSort {
    private int heapLength;
    //in-place deal with the item at index i
    //which might violate the heap property
    //time complexity lg(n)
    public void maxHeapify(int[] a, int i){
        int l = i*2; //left-child
        int r = l+1; //right-child
        int largest = i;
        if(l < this.heapLength && a[l] > a[i])
            largest = l;
        if(r < this.heapLength && a[r] > a[largest])
            largest = r;
        if(largest != i){
            //swap child and parent
            int tmp = a[i];
            a[i] = a[largest];
            a[largest] = a[i];
            //check new child 
            maxHeapify(a, largest);
        }
    }
    //build a heap from unsorted array
    //time complexity: linear
    public void buildMaxHeap(int[] a){
        for(int i = a.length/2; i>=1; i--)
            maxHeapify(a, i);
    }
    //heap sort, in-place, nlgn
    public void heapSort(int[] a){
        buildMaxHeap(a);
        this.heapLength = a.length-1;
        for(int i = a.length-1; i>=2; i--){
            int tmp = a[1];
            a[1] = a[i];
            a[i] = tmp;
            this.heapLength--;
            maxHeapify(a, 1);
        }
    }
}
