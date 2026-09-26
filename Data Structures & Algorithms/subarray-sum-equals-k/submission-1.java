class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCounts = new HashMap<>();
        sumCounts.put(0, 1);

        int sol = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int tgt = sum - k;
            if (sumCounts.containsKey(tgt)) sol += sumCounts.get(tgt);

            if (sumCounts.containsKey(sum)) sumCounts.put(sum, sumCounts.get(sum) + 1);
            else sumCounts.put(sum, 1);
        }
        
        return sol;
    }
    /*
    1 3 6

      0 0 0
    0 0 0 0

      -1 0 -1
    0 -1 -1 0

    */
}