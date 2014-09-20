//greedy
public class JumpGame2 {
	public int jump(int[] A) {
        if(A == null || A.length <= 1) return 0;
        int steps = 0;
        int far = 0;
        int start = 0, finish = 0;
        while(far < A.length-1){
            steps++;
            for(int i = start; i <= finish; i++)
                far = Math.max(far, i+A[i]);
            start++; 
            finish = far;
        }
        return steps;    
    }
}
