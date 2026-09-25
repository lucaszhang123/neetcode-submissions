class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int furthestRight = nums.length - 1;
        int[] stepsNeeded = new int[nums.length];
        Arrays.fill(stepsNeeded, Integer.MAX_VALUE);

        stepsNeeded[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] >= nums.length - 1) return stepsNeeded[i] + 1;
            for (int j = nums[i]; j > 0; j--) {
                if (stepsNeeded[i + j] > stepsNeeded[i] + 1) {
                    stepsNeeded[i + j] = stepsNeeded[i] + 1;
                }
                else break;
            }
        }

        return stepsNeeded[nums.length - 1];
    }
}
