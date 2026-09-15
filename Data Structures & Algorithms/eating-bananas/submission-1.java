class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = -1;
        for (int height : piles) {
            if (height > max) max = height;
        }

        while (min <= max) {
            int mid = (min + max)/2;
            if (numTurns(piles, mid) > h) {
                min = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }
        return min;
    }
    /*
    1 4 3 2

    min 1 max 4
    2 --> 5
    min 1 max 1
    1 --> 10
    m


    */

    public int numTurns(int[] piles, int k) {
        int turns = 0;
        for (int h : piles) {
            if (h % k == 0) turns += h/k;
            else turns += h/k + 1;
        }
        return turns;
    }
}
