class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int prev = Integer.MAX_VALUE;

        for (int p : prices) {
            if (p > prev) {
                profit += p - prev;
            }
            prev = p;
        }

        return profit;
    }
}