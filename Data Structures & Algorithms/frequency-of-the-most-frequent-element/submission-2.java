class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            diff[i] = nums[nums.length - 1] - nums[i]; 
        }

        int maxFreq = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            int iFreq = 1;
            int currCount = 0;
            for (int j = i - 1; j >= 0; j--) {
                currCount += diff[j] - diff[i];
                if (currCount <= k) {
                    iFreq++;
                }
                else {
                    break;
                }
            }

            maxFreq = Math.max(maxFreq, iFreq);
        } 

        return maxFreq;

    }
    /*
    3 4 5
    3 7 12
    1 2
    1 3

    12 9 5 0


    


    10
    1 2 3 4 5
    1 1 1 1
    1 2 3 4
    */
}