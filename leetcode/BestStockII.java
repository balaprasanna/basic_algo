//leetcode, DP
//this is the dummy O(n^2) method which exceeds the time limits of test cases

public class BestStockII {
	public static int maxProfit(int[] prices) {
        int l = prices.length;
        int max_prof = 0;
        for (int i = 0; i < l-1; i++){
            int cur = intervalProfit(prices, 0, i)+intervalProfit(prices, i+1, l);
            max_prof = (max_prof >= cur)? max_prof: cur;
        }
        int last = intervalProfit(prices, 0, l);
        max_prof = (max_prof >= last)? max_prof : last;
        
        return max_prof;
        
    }
    //param: start included, end excluded
    private static int intervalProfit(int[] prices, int start, int end){
        //corner cases
        if (start == end) return 0;
        
        int min_val = prices[start];
        int max_prof = 0;
        for (int i = start; i < end; i++){
            min_val = (min_val <= prices[i])? min_val: prices[i];
            max_prof = (max_prof >= prices[i] - min_val)? max_prof :(prices[i] - min_val);
        }
        return max_prof;
    }
    public static void main(String[] args){
    	int[] prices = {1,2,3,4,5};
    	System.out.print(maxProfit(prices));
    }
}
