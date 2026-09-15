class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < nums.length) {
            if (nums[right] > target) return 1;
            sum += nums[right];
            if (sum >= target) {
                while (sum >= target) {
                    if (right - left + 1 < length || length == 0) length = right - left + 1;
                    sum -= nums[left];
                    left++;
                }
            }
            right++;
        }

        return length;
    }
}