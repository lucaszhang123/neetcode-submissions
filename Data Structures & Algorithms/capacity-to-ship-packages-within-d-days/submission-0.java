class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int weightSum = 0;
        for (int w : weights) {
            weightSum += w;
        }

        int l = 0;
        int r = weightSum;

        while (l < r) {
            int m = (r + l)/ 2;

            if (min(weights, m) > days) {
                l = m + 1;
                System.out.println(m + " too small");
            } else {
                r = m;
                System.out.println(m + " too large");
            }
        }

        return l;
    }

    public int min(int[] weights, int cap) {
        int count = 1;
        int currSum = 0;

        for (int w : weights) {
            if (w > cap) {
                return Integer.MAX_VALUE;
            }
            if (currSum + w <= cap) {
                currSum += w;
            } else {
                currSum = w;
                count++;
            }
        }
        return count;
    }
}
/*

1 6 10 14 16 19
*/