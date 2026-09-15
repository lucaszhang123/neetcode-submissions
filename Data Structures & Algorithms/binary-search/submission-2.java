class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, target, nums.length - 1, 0);
    }
    private int bs(int[] nums, int target, int hi, int lo) {
        if (lo > hi) return -1;

        int mid = (hi + lo)/2;
        if (nums[mid] == target) return mid;
        

        if (nums[mid] < target) {
            return bs(nums, target, hi, mid + 1);
        }
        else {
            return bs(nums, target, mid - 1, lo);
        }

    }
}
