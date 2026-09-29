class Solution {
    List<List<Integer>> sol = new ArrayList<>(); 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(0, candidates, target, new ArrayList<Integer>());
        return sol;
    }

    public void bt(int start, int[] candidates, int remaining, List<Integer> currSet) {
        if (remaining == 0) {
            sol.add(new ArrayList<>(currSet));
            return;
        }

        for (int j = start; j < candidates.length; j++) {
            if (j > start && candidates[j] == candidates[j - 1]) continue; 
            if (candidates[j] > remaining) break;

            currSet.add(candidates[j]);
            bt(j + 1, candidates, remaining - candidates[j], currSet);
            currSet.remove(currSet.size() - 1);
        }
    }
    /*

    8 8 8
    8 8 8
    
     
    */
}
