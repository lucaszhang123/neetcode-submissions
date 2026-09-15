class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] numSteps = new int[n];
        numSteps[0] = 1;
        numSteps[1] = 2;

        for (int i = 2; i < n; i++) {
            numSteps[i] = numSteps[i - 1] + numSteps[i - 2];
        }

        return numSteps[n - 1];
    }
}
