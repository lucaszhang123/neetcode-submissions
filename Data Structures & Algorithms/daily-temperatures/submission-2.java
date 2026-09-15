class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> s = new Stack<>();

        int[] streak = new int[temperatures.length];
        s.push(new int[]{temperatures[0], 0});
        for (int i = 1; i < temperatures.length; i++) {
            while (s.size() > 0 && s.peek()[0] < temperatures[i]) {
                int[] popped = s.pop();
                streak[popped[1]] = i - popped[1];
            }
            s.push(new int[]{temperatures[i], i});
        }

        return streak;
     }
}
