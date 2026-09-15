class Solution {
    private Set<List<Integer>> validSols = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); //sort first
        bt(0, 0, target, candidates, new ArrayList<Integer>());
        return new ArrayList<>(validSols);
    }

    public void bt(int start, int currSum, int target, int[] candidates, ArrayList<Integer> seq) {
        if (currSum == target) {
            ArrayList<Integer> copy = new ArrayList<Integer>(seq);
            Collections.sort(copy);
            validSols.add(copy);
            return;
        }
        if (currSum > target) return;

        for (int i = start; i < candidates.length; i++) {
            if (i > start + 1 && candidates[i] == candidates[i - 1]) continue;  
            //need to understand above line better 
            seq.add(candidates[i]);
            bt(i + 1, currSum + candidates[i], target, candidates, seq);
            seq.remove(seq.size() - 1);
        }
    }
}
/*
9 2 2 4 6 1 5

1. 9 > 8 X
2. 2 --> 2 4 
2. 2 --> 4 1 X
2. 2 --> 6 
2. 2 --> 1 5 
3. 2 4 6 

1 1 2 2 2 2 4 5 6 9

1 2 2 

bc: if currSum == target --> sort list, add clone to valid sols, return;
    if currSum > target --> return;

loop (i = startIndex --> end) {
    add nums[i] to list
    bt(start = i, currSum = currSum + nums[i], target, candidates, list)
    remove nums[i] from list
}
*/


