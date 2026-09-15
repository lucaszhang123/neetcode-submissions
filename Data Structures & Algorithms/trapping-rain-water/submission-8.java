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
        Stack<int[]> stack = new Stack<int[]>();
        int index = 0;
        
        while (index < height.length) {
            if  (stack.size() == 0) {
                int[] first = {height[0], 0, 0, 0}; 
                stack.push(first);
            }
            else {
                int area_bars = 0;
                int area_rain;
                while (stack.size() > 1 && stack.peek()[0] < height[index]) {
                    int[] prev = stack.pop();
                    area_bars += prev[0] + prev[2];
                }

                if (stack.size() == 1 && stack.peek()[0] < height[index]) {
                    int[] prev = stack.pop();
                    area_rain = (index - prev[1] - 1)*prev[0] + prev[3] - area_bars;
                }
                else {
                    int[] prev = stack.peek();
                    area_rain = (index - prev[1] - 1)*height[index] - area_bars;
                }
                int[] curr = {height[index], index, area_bars, area_rain};
                stack.push(curr);
            }
            index++;
            
        }
        int sum = 0;
        while (stack.size() > 0) {
            int[] curr = stack.pop();
            sum+= curr[3];
        }

        return sum;
    }
}
