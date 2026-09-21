class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int[] cnt = new int[1001];
        int start = 1001;
        for (int i : hand) {
            cnt[i]++;
            start = Math.min(start, i);
        }

        int counter = 0;

        while (counter < hand.length) {
            int nextMin = 1001;
            for (int i = 0; i < groupSize; i++) {
                if (cnt[i + start] == 0) return false;

                counter++;
                cnt[i + start]--;

                if (cnt[i + start] != 0) nextMin = Math.min(nextMin, i + start);
            }


            if (nextMin == 1001) {
                for (int i = 0; i < 1001; i++) {
                    if (cnt[i] != 0) {
                        nextMin = i;
                        break;
                    }
                }
            }
            start = nextMin;
        }
        return true;

    }
}
