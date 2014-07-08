public class Merge {
    private Comparable[] aux = null;
    private void merge(Comparable[] a, Comparable[] aux,
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
    
    private void sort(Comparable[] a, Comparable[] aux, 
                      int lo, int hi)
    {
        //practical improvement: use insertion sort instead of merge sort for 
        //tiny arrays
        if (hi < lo) return;
        int mid = (lo + hi)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1,hi);
        //practical improvement: array already sorted
        if (a[mid].compareTo(a[mid+1])<0) return;
        merge(a, aux, lo, mid, hi);
    }
    
    public void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }
    
    public void bottomUpMerge(Comparable[] a)
    {
        //This is the bottom up method of coding up merge, no recursive
        //lgN passes through the array altogether
        int N = a.length;
        aux = new Comparable[N];
        for (int sz=1; sz<N; sz = sz + sz)
            for (int lo = 0; lo < N; lo=lo+sz)
                merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N));
    }
}