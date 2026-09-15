class Solution {
    public boolean canJump(int[] nums) {
        boolean[] reachable = new boolean[nums.length];
        int tgt = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int d = tgt - i;
            if (d - nums[i] <= 0) {
                tgt = i;
                System.out.println("can reach " + tgt + "from " + i);
            }
            else System.out.println("cant reach " + tgt + "from " + i);
        }
        if (tgt == 0) return true;
        else return false; 
    }
}
