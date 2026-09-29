class Solution {
    /*
    stack:
    0: height
    1: index of bar
    2: area of bars between
    3: area of rain water between

    4-->(4,0,0,0)
    2-->(4,0,0,0) (2,1,0,0)
    0-->(4,0,0,0) (2,1,0,0) (0,2,0,0)
    3-->(4,0,0,0) (3,3,2,4); a_bar = 0+0 + 2+0 = 2; a_rain = (3-0-1)*3-2=4
    2-->(4,0,0,0) (3,3,2,4) (2,4,0,0)
    5-->2+3+2=7; a_bar = 2+0 + 3+2 = 7; a_rain = (5-0-1)*4-7=9
    */
    public int trap(int[] height) {
        int[] greatestOnLeft = new int[height.length];
        int[] greatestOnRight = new int[height.length];

        int maxOnLeft = -1;
        for (int i = 0; i < height.length; i++) {
            greatestOnLeft[i] = maxOnLeft;
            maxOnLeft = Math.max(maxOnLeft, height[i]);
        }

        int maxOnRight = -1;
        for (int i = height.length - 1; i >= 0; i--) {
            greatestOnRight[i] = maxOnRight;
            maxOnRight = Math.max(maxOnRight, height[i]);
        }

        int sol = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < greatestOnLeft[i] && height[i] < greatestOnRight[i]) {
                sol += Math.min(greatestOnLeft[i], greatestOnRight[i]) - height[i];
            }
        }

        return sol;
    }
}

/*


*/
