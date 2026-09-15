class Solution {
    public boolean canJump(int[] nums) {
        int tgt = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int d = tgt - i;
            if (d - nums[i] <= 0) {
                tgt = i;
            }
        }
        if (tgt == 0) return true;
        else return false; 
    }
}
