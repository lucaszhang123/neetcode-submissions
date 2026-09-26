class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;

        while (l <= r) {
            int m = l + (r - l)/2;

            long sq = (long) m * m;

            if (sq > (long) x) r = m - 1;
            else if (sq < (long) x) l = m + 1;
            else return m;
        }

        return r;
    }
}