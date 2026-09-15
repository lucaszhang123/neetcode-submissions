class Solution {
    public int twoCitySchedCost(int[][] costs) {
        List<int[]> deltas = new ArrayList<>();

        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            deltas.add(new int[]{cost[0] - cost[1], i});
        }

        Collections.sort(deltas, (a,b) -> a[0]-b[0]);

        boolean[] chooseA = new boolean[costs.length];
        for (int i = 0; i < costs.length/2; i++) {
            chooseA[deltas.get(i)[1]] = true;
        }

        int tc = 0;
        for (int i = 0; i < costs.length; i++) {
            if (chooseA[i]) tc += costs[i][0];
            else tc += costs[i][1];
        }
    
        return tc;
    }
}