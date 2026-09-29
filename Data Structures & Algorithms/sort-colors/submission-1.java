class Solution {
    public void sortColors(int[] nums) {
        int w = 0;
        int r = 0;
        int b = 0;

        for (int i : nums) {
            if (i == 0) r++;
            else if (i == 1) w++;
            else b++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < r) nums[i] = 0;
            else if (i < r + w) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}