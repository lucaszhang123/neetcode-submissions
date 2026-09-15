class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] min = new int[amount + 1];
        Arrays.fill(min, - 1);
        min[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            int minRequired = -1;
            for (int coin : coins) {
                if (i - coin < 0 || min[i - coin] == -1) continue;
                if (min[i - coin] + 1 < minRequired || minRequired == -1) {
                    minRequired = min[i - coin] + 1;
                }

                min[i] = minRequired;
            }
        }

        return min[amount];

    }
}
