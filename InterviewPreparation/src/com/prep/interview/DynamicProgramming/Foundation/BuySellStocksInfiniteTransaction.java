package com.prep.interview.DynamicProgramming.Foundation;

public class BuySellStocksInfiniteTransaction {
	public static int buySellStocks2(int[] prices) {
		int buy_date = 0;
		int sell_date = 0;
		int profit = 0;
		for(int i = 1 ; i < prices.length ; i++){
			if(prices[i] >= prices[i-1])
				sell_date++;
			else{
				profit += prices[sell_date] - prices[buy_date];
				buy_date = sell_date = i;
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		int prices[] = {10,15,17,20,16,18,22,20,20,22,20,23,25};
		int profit = buySellStocks2(prices);
		System.out.println("Max Profit for Infinite Transaction : " + profit);
	}
}
