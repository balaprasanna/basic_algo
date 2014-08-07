public class ReverseIntegerSolution { 
    public int reverse(int x) { 
        if (x == 0) return 0; 
        boolean pos = x>0 ? true: false; 
        int abs = x>0? x: -x;  
        int revert = 0; 
        for (int i = abs; i > 0; i = i/10) 
            revert = 10*revert + i%10; 
        if (pos) return revert; 
        else return -revert; 
    } 
}