public class Merge_my {
    private Merge_my() {}
    private static void merge(Comparable[] a, Comparable[] aux,
                       int lo, int mid, int hi)
    {
        assert isSorted(a,lo,mid);
        assert isSorted(a,mid+1,hi);
        
        for (int k=lo; k<=hi; k++)
            aux[k] = a[k];
        int i = lo;
        int j = mid+1;
        for (int k=lo; k<=hi; k++)
        {
            if (i>mid) a[k] = aux[j++];
            else if (j>hi) a[k] = aux[i++];
            else if (aux[i].compareTo(aux[j])<0) a[k]=aux[i++];
            else a[k]=aux[j++];
        }
        
        assert isSorted(a,lo,hi);
    }
    
    private static void sort(Comparable[] a, Comparable[] aux, 
                      int lo, int hi)
    {
        //practical improvement: use insertion sort instead of merge sort for 
        //tiny arrays
        if (hi <= lo) return;
        int mid = (lo + hi)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1,hi);
        //practical improvement: array already sorted
        if (a[mid].compareTo(a[mid+1])<0) return;
        merge(a, aux, lo, mid, hi);
    }
    
    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }
    
    public void bottomUpMerge(Comparable[] a)
    {
        //This is the bottom up method of coding up merge, no recursive
        //lgN passes through the array altogether
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz=1; sz<N; sz = sz + sz)
            for (int lo = 0; lo < N; lo=lo+sz)
                merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N));
    }
   
    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
    /***********************************************************************
    *  Check if array is sorted - useful for debugging
    ***********************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
    /**
     * Reads in a sequence of strings from standard input; mergesorts them; 
     * and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Merge_my.sort(a);
        show(a);
    }
    
}