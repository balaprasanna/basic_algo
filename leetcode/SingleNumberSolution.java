public class SingleNumberSolution { 
    public int singleNumber(int[] A) { 
        int a = 0; 
        for (int i = 0 ; i < A.length; i++) 
            a ^= A[i]; 
        return a; 
    } 
}