//搞了半天，题意都没弄明白，扯淡
//need reviewing and futher improvement
public class Candy {
	public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;
        int n =  ratings.length;
        int[] candy = new int[n];
        candy[0] = 1;
        for(int i = 1; i< n; i++){
            if(ratings[i] > ratings[i-1])
                candy[i] = candy[i-1]+1;
            //else if(ratings[i] == ratings[i-1])
            //    candy[i] = candy[i-1];
            else 
                candy[i] = 1;
        }
        int[] right = new int[n];
        right[n-1] = 1;
        for(int i = n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1])
                right[i] = right[i+1]+1;
            //else if(ratings[i] == ratings[i+1])
            //    right[i] = right[i+1];
            else
                right[i] = 1;
        }
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += Math.max(candy[i],right[i]);
        return sum;
    }
}
