class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] maxRob = new int[nums.length];
        int[] maxDont = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                maxRob[i] = nums[i];
                maxDont[i] = 0;
                continue;
            }
            if (i == 1) {
                maxDont[i] = nums[i];
                maxRob[i] = Math.max(maxRob[0], maxRob[1]);
                continue;
            }

            
            maxDont[i] = Math.max(maxDont[i - 2] + nums[i], maxDont[i - 1]);

            if (i != nums.length - 1) {
                maxRob[i] = Math.max(maxRob[i - 2] + nums[i], maxRob[i - 1]);
            }
            else {
                maxRob[i] = maxRob[i -1];
            }
        }
        return Math.max(maxRob[nums.length - 1], maxDont[nums.length - 1]);
    }
    /*
    2 9 8 3 6
    */

}
