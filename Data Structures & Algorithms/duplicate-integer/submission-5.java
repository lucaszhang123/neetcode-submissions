class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (m.containsKey(num)) return true;
            else m.put(num, 0);
        }
        return false;
    }
}