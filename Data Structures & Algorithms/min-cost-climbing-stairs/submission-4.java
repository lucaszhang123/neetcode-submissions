class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 0;
        return fillMemo(cost.length, memo, cost);
    }

    public int fillMemo(int i, int[] memo, int[] cost) {
        if (memo[i] != -1) return memo[i];



        int store = Math.min(fillMemo(i - 1, memo, cost) + cost[i - 1], 
        fillMemo(i - 2, memo, cost) + cost[i - 2]);

        memo[i] = store;
        return store;

    }


}
