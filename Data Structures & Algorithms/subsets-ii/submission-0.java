class Solution {
    List<List<Integer>> sol;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        sol = new ArrayList<>();
        Arrays.sort(nums);

        bt(0, nums, new ArrayList<Integer>(), false);

        return sol;

    }

    public void bt(int index, int[] nums, List<Integer> curr, boolean prevChosen) {
        if (index == nums.length) {
            sol.add(new ArrayList<>(curr));
            return;
        }

        if (index > 0 && nums[index - 1] == nums[index] && !prevChosen) {
            bt(index + 1, nums, curr, false);
        }
        else {
            curr.add(nums[index]);
            bt(index + 1, nums, curr, true);
            curr.remove(curr.size() - 1);
            bt(index + 1, nums, curr, false);
        }
    }
}
