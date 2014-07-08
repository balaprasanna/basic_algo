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
        if (hi < lo) return;
        int mid = (lo + hi)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1,hi);
        merge(a, aux, lo, mid, hi);
    }
    
    public void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }
}