package No48_50_Arrays_And_List;

public class Q5_121_Buy_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int min = prices[0];
        int maxProfit = 0;
        int ans = 0;
        for (int price : prices){
            if(min > price){
                min = price;
            } else if (maxProfit < price - min) {
                maxProfit = price - min;
            }
//            min = Math.min(min,price);
//            maxProfit = Math.max(maxProfit, price - min);
        }
        System.out.println(maxProfit);
    }
}
