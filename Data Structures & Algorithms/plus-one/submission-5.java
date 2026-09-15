class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;

        while (true) {
            if (index == -1) {
                break;
            }
            if (digits[index] != 9) {
                digits[index]++;
                return digits;
            } 
            digits[index] = 0;
            index--;
        }

        int[] tbr = new int[digits.length + 1];
        tbr[0] = 1;
        return tbr;
    }
}
