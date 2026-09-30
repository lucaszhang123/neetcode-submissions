class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }

        return dp[amount];
        
    }
    /*

    1 2 3

    _ 1 2 3 4

    0 1 2 3 4 

    */
}
