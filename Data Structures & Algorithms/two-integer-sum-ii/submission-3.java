class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lp = 0;
        int rp = numbers.length - 1;
        int[] tbr = new int[2];
        while (lp < rp) {
            int sum = numbers[lp] + numbers[rp];

            if (sum == target) {
                tbr[0] = lp + 1;
                tbr[1] = rp + 1;
                break;
            }
            else if (sum < target) lp++;
            else rp--;
        }
        return tbr;
    }
}
