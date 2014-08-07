//solution for Unique Paths
public class Solution { 
    public int uniquePaths(int m, int n) { 
        if (m == 1 || n == 1) return 1; 
        int[] a = new int[n]; 
        a[0] = 1; 
        for (int j = 0; j < m; j++) 
            for (int i = 1; i < n; i++) 
            { 
                if (j == 0) a[i] = 1; 
                else a[i] += a[i-1]; 
            } 
        return a[n-1]; 
    } 
}