//leetcode DP
//optimization to O(n)
//forward and backward scan
public class BestStockII2 {
	public int maxProfit(int[] prices) {
		 if (prices == null || prices.length <= 1) return 0;
		 int len = prices.length;
		 int[] forward = new int[len];
		 int[] backward = new int[len];
		 //forward scan for max_prof at each price
		 int min_val = prices[0];
		 int max_prof = 0;
		 for (int i = 0; i< len; i++){
			 min_val = (min_val <= prices[i])? min_val: prices[i];
			 max_prof = (max_prof >= (prices[i]-min_val))? max_prof:(prices[i]-min_val);
			 forward[i] = max_prof;
		 }
		 //backward scan for max_prof
		 int max_val = prices[len-1];
		 max_prof = 0;
		 for (int i = len-1; i>0; i--){
			 max_val = (max_val >= prices[i])? max_val: prices[i];
			 max_prof = (max_prof >= (max_val -prices[i]))? max_prof:(max_val -prices[i]);
			 backward[i] = max_prof;
		 }
		 //scan through all intervals to find sum of two transactions to compete one transaction
		 max_prof = forward[len-1];
		 for(int i = 1; i<len; i++)
			 max_prof= (max_prof >= (forward[i]+backward[i]))? max_prof : (forward[i]+backward[i]);
		 
		 return max_prof;
		 
	 }
}
