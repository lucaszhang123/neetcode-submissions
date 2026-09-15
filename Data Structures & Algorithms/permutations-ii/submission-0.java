class Solution {
    Set<List<Integer>> sol;

    public List<List<Integer>> permuteUnique(int[] nums) {
        sol = new HashSet<>();
        boolean[] used = new boolean[nums.length];

        bt(used, nums, new ArrayList<>());

        List<List<Integer>> list = new ArrayList<>(sol);

        return list;

    }

    public void bt(boolean[] used, int[] nums, List<Integer> curr) {
        if (curr.size() == nums.length) {
            sol.add(new ArrayList<>(curr));

        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            used[i] = true;
            curr.add(nums[i]);
            bt(used, nums, curr);
            
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}