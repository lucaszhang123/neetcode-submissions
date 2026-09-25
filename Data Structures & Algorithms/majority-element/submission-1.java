class Solution {
    public int majorityElement(int[] nums) {
        int cand = 0;
        int cCount = 0;
        for (int num : nums) {
            if (cCount == 0) {
                cand = num;
                cCount++;
            }
            else {
                if (cand == num) cCount++;
                else cCount--;
            }

        }
        return cand;
    }

}