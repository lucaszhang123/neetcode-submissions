class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int cumSum = 0;

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            cumSum += nums[i];

            if (cumSum == k) cnt++;
            int lookup = cumSum - k;

            if (m.containsKey(lookup)) cnt += m.get(lookup);

            if (m.containsKey(cumSum)) m.put(cumSum, m.get(cumSum) + 1);
            else m.put(cumSum, 1);


        }

        return cnt;


    }
    /*

    2 1 2 4
    1 --> 1
    2 --> 2
    4 --> 1


    */
}