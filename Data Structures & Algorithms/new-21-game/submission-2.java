class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (n >= k + maxPts - 1) return 1;

        double[] probLand = new double[k + maxPts + 1];
        probLand[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            double prob = 0;
            for (int j = 1; j < maxPts + 1; j++) {
                if (i - j < 0 || i - j >= k) continue;
                prob += (1.0 / maxPts) * probLand[i - j];
            }
            probLand[i] = prob;
            //System.out.println(probLand[i]);
        }

        double res = 0;
        for (int i = k; i <= n; i++) {
            res += probLand[i];
        }
        return res;

    }
}