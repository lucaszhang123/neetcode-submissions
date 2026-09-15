class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        Set<Integer> inWindow = new HashSet<>();
        boolean contains = false; 
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                if (inWindow.contains(nums[i])) return true;
                inWindow.add(nums[i]);
            }
            else {
                if (inWindow.contains(nums[i])) return true;
                inWindow.remove(nums[i - k]);
                inWindow.add(nums[i]);
            }
        }

        return contains;
    }
}