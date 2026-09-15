class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> m = new HashSet<Integer>();
        for (int num : nums) {
            if (m.contains(num)) return true;
            else m.add(num);
        }
        return false;
    }
}