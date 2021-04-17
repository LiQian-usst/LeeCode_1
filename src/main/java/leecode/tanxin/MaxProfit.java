package leecode.tanxin;

public class MaxProfit {
    // 121. 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice= prices[i];
            }else {
                maxProfit = Math.max(maxProfit,prices[i]-minPrice);
            }
        }
        return maxProfit;
    }
}
