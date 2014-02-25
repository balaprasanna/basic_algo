public class Merge {
    private Comparable[] aux = null;
    public void sort(Comparable[] a)
    { 
        aux = new Comparable[a.length]; 
        sort(a, aux, 0, a.length-1);
    }
    public void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if( hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, hi, mid);
    }
    public void merge(Comparable[] a, Comparable[] aux, int lo, int hi, int mid)
    {
        //assert isSorted(a, lo, mid);
        //assert isSorted(a, mid, hi);
        
        for(int k = lo; k<hi; k++)
            aux[k] = a[k];
        
        int i = lo, j = mid+1;
        for(int k = lo; k < hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
    public boolean less(Comparable a , Comparable b)
    {
        if (a.compareTo(b) < 0) return true;
        else return false;
    }
}