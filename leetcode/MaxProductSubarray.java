//这题也是有点绕，各种corner case

public class MaxProductSubarray {
	public int maxProduct(int[] A) {
        if(A==null || A.length ==0) return 0;
        int min = 0;
        int max = 0;
        int result = A[0];
        for(int i =0; i < A.length; i++){
            int cur = A[i];
            if(cur == 0){
                min = 0;
                max = 0;
                result = Math.max(result, max);
            }else if(cur>0){
                if(max == 0) 
                    max = cur;
                else
                    max *= cur;
                if(min!= 0 ) min *= cur;
                result = Math.max(result, max);
            }else{
                int tmp = 0; //new_min
                if(max == 0)
                    tmp = cur;
                else
                    tmp = max*cur;
                if(min != 0)
                    max = min*cur;
                else 
                    max = 0;
                min = tmp;
                if(max == 0)
                    result = Math.max(result, min);
                else
                    result = Math.max(result, max);
            }
        }
        return result;
    }
}
