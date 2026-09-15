class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int i : piles) {
            r = Math.max(i, r);
        }

        while (l < r) {
            int m = l + (r - l)/2;
            int numDays = 0;
            for (int i : piles) {
                if (i % m == 0) numDays += i/m;
                else numDays += i/m + 1;
            }

            if (numDays > h) {
                l = m + 1; 
            }
            else {
                r = m;
            }
        }

        return r;
    }
}