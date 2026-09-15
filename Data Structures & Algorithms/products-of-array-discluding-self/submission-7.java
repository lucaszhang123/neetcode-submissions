class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rollingSumLeft = new int[nums.length];
        int[] rollingSumRight = new int[nums.length];
        
        int sumLeft = 1;
        int sumRight = 1;
        for (int i = 0; i < nums.length; i++) {
            sumLeft *= nums[i];
            rollingSumLeft[i] = sumLeft;

            sumRight *= nums[nums.length - 1 - i];
            rollingSumRight[nums.length - 1 - i] = sumRight;
        }

        int[] pmi = new int[nums.length];
        pmi[0] = rollingSumRight[1];
        for (int i = 1; i < nums.length - 1; i++) {
            pmi[i] = rollingSumLeft[i - 1] * rollingSumRight[i + 1];
        }
        pmi[nums.length - 1] = rollingSumLeft[nums.length - 2];

        return pmi;
    }
}  
