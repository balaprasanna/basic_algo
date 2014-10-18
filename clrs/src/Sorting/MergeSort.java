package Sorting;

public class MergeSort {
    public static void mergeSort(int[] array){
        if(array == null || array.length <= 1) return;
        mergeSort(array, 0, array.length-1);
    }
    public static void mergeSort(int[] array, int p, int q){
        if(p < q){
            int m = (p+q)/2;
            mergeSort(array, p, m);
            mergeSort(array, m+1, q);
            merge(array, p, m, q);
        }
    }
    public static void merge(int[] array, int p, int m, int q){
        int[] left = new int[m-p+2]; //one more place for sentinal
        for(int i = p; i <=m; i++)
            left[i-p] = array[i];
        //set a sentinal to save boundary checking
        left[left.length-1] = Integer.MAX_VALUE;
        int[] right = new int[q-m+1];
        for(int i = m+1; i<=q; i++)
            right[i-m-1] = array[i];
        right[right.length -1] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for(int k = p; k<=q; k++){
            if(left[i]<right[j]){
                array[k] = left[i];
                i++;
            }else{
                array[k] = right[j];
                j++;
            }
        }
    }
    public static void main(String[] args){
        int[] test = {2,6,5,3,8,1,3};
        mergeSort(test);
        for(int item: test)
            System.out.println(item);
    }
}
