class Solution {
    /*
    1 2 3

    1 2 3
    1 3 2
    */
    List<List<Integer>> perms;

    public List<List<Integer>> permute(int[] nums) {
        perms = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        bt(seq, used, nums);
        return perms;
    }
    public void bt(List<Integer> perm, boolean[] used, int[] nums) {
        if (perm.size() == used.length) {
            perms.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;

            perm.add(nums[i]);
            used[i] = true;
            bt(perm, used, nums);
            used[i] = false;
            perm.remove(perm.size() - 1);
        }
    }
}
