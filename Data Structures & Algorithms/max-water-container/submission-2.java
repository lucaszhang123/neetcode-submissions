class Solution {
    public int maxArea(int[] heights) {
        int lp = 0;
        int rp = heights.length - 1;
        int maxArea = 0;

        while (lp < rp) {
            int curr = Math.min(heights[lp], heights[rp]) * (rp - lp);
            if (curr > maxArea) maxArea = curr;

            if (heights[lp] < heights[rp]) lp++;
            else rp--;
        }

        return maxArea;
    }
}
