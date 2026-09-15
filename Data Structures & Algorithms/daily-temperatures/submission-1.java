class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] answers = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (stack.size() != 0 && temperatures[i] > stack.peek()[0]) {
                int[] popped = stack.pop();
                answers[popped[1]] = i - popped[1];
            }
            int[] tba = {temperatures[i], i};
            stack.push(tba);
        }

        while (stack.size() != 0) {
            int[] popped = stack.pop();
            answers[popped[1]] = 0; 
        }

        return answers;
    }
    /*
    30 38 30 36 35 40 28


    */
}
