package Sorting;

import java.util.Random;

public class Selection {
    public int maximum(int[] a){
        int max = a[0];
        for(int i = 1; i < a.length; i++)
            if(max < a[i])
                max = a[i];
        return max;
    }
    //the ith smallest item in array
    //expected time complexity (n)
    public static int randSelect(int[] a, int p, int q, int i){
        //base case
        if(p == q) return a[p];
        int r = randPartition(a, p ,q);
        int k = r-p+1;
        if(i == k)
            return a[i];
        else if(i < k)
            return randSelect(a, p, r-1, i);
        else
            return randSelect(a,r+1,q, i-k);
    }
    public static int randPartition(int[] a, int p, int q){
        Random rand = new Random();
        int r = rand.nextInt(q-p+1)+p;
        swap(a, r, q);
        
        int key = a[q];
        int i = p-1;
        for(int j = p; j < q; j++)
            if(key > a[j]){
                i++;
                swap(a, i , j);
            }
        swap(a, i+1, q);
        return i+1;
    }
    private static void swap(int[] a, int p, int q){
        if(p!=q){
            int tmp = a[p];
            a[p] = a[q];
            a[q] = tmp;
        }
    }
    public static void main(String[] args){
        int[] test = {2,6,5,3,8,1,3};
        int re = randSelect(test, 0, test.length-1, 4);
        System.out.println(re);
    }
}
