public class Quick{
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }
    public static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int  j = partition(a, lo, hi);
        sort(a, lo, j);
        sort(a, j+1, hi);
    }
    public static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi;
        Comparable v = a[lo];
        while (true)
        {
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    private static void exch(Comparable[] a, int m, int n)
    {
        Comparable temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
    private static boolean less(Comparable a, Comparable b)
    {
        if (a.compareTo(b) < 0)
            return true;
        else return false;
    }
    // selection the K th largest in linear time based on partition
    public static Comparable select(Comparable[] a, int k)
    {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length-1;
        while (hi > lo)
        {
            int j = partition(a, lo, hi);
            if (j > k ) hi = j-1;
            else if (j < k) lo = j+1;
            else return a[k];
        }
        return a[k];
    }
}