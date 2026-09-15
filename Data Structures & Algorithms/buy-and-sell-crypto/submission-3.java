class Solution {
    public int maxProfit(int[] prices) {
        int bestProfit = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (rightIndex < prices.length - 1) {
            rightIndex++;
            int currProfit = prices[rightIndex] - prices[leftIndex];
            if (currProfit > bestProfit) bestProfit = currProfit;

            if (prices[rightIndex] < prices[leftIndex]) {
                leftIndex = rightIndex;
            }
        }

        return bestProfit;

    }
}
