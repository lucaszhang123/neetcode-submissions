class Solution {
    public void rotate(int[] nums, int k) {
        int[] rotated = new int[nums.length];

        int r = k % nums.length;

        for (int i = 0; i < nums.length; i++) {
            int rot = (i + r - nums.length >= 0) ?  i + r - nums.length : i + r;
            rotated[rot] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rotated[i];
        }

    }
}