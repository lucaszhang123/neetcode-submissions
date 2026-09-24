class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            
            int l = i + 1;
            int r = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (l < r) {
                if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                }
                else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                }
                else {
                    sol.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1])  l++;
                }
            }
        }
        
        return sol;
    }
}
