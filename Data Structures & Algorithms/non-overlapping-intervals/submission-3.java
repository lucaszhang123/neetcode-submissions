class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int endVal = intervals[0][1];
        int cnt = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= endVal) {
                endVal = intervals[i][1];
            }
            else {
                if (intervals[i][1] < endVal) {
                    endVal = intervals[i][1];
                }
                cnt++;
            }

            
        }
        return cnt;
    }
}
