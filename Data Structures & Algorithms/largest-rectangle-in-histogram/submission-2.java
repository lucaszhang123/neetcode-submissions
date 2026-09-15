class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        Stack<int[]> s = new Stack<>();
        int maxArea = heights[0];
        int[] first = {heights[0], 0};

        s.push(first);

        for (int i = 1; i < heights.length; i++) {
            int[] tba = {heights[i], i};
            if (s.peek()[0] > heights[i]) {
                while (s.size() > 0 && s.peek()[0] > heights[i]) {
                    int[] prev = s.pop();
                    if (s.size() > 0) {
                        maxArea = Math.max(maxArea, prev[0] * (i - s.peek()[1] - 1));
                    }
                    else maxArea = Math.max(maxArea, prev[0] * i);
                }
                
                s.push(tba);
            }

            else {
                s.push(tba);
            }
        }

        while (s.size() > 0) {
            int[] curr = s.pop();
            if (s.size() == 0) {
                maxArea = Math.max(maxArea, curr[0] * heights.length);
                break;
            }
            int[] prev = s.peek();
            maxArea = Math.max(maxArea, curr[0]*(heights.length - prev[1] - 1));
        }
        return maxArea;
    }
}
