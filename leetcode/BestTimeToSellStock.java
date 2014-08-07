public class BestTimeToSellStock { 
public int maxProfit(int[] prices) { 
    if (prices.length == 0) return 0; 
    int lowestPrice = prices[0], mp = 0; 
    for (int i = 0 ; i < prices.length; i++){ 
        lowestPrice = prices[i] > lowestPrice ? lowestPrice : prices[i]; 
        mp = mp >(prices[i]-lowestPrice ) ? mp : (prices[i]-lowestPrice); 
    } 
    return mp; 
}}