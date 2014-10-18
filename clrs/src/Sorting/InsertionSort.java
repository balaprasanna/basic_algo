package Sorting;
//Comparison based sorting, in-place
//Time complexity: O(n^2), worst-case: descending items

public class InsertionSort {
    public static int[] insertionSort(int[] array){
        if(array == null || array.length <= 1) return array;
        for(int i =1; i < array.length; i++){
            int key = array[i];
            int j = i-1;
            //only shift, no swap
            while(j>=0 && array[j]>key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        return array;
    }
    public static void main(String[] args){
        int[] test = {2,6,5,3,8,1,3};
        int[] result = insertionSort(test);
        for(int item: result)
            System.out.println(item);
    }
}
