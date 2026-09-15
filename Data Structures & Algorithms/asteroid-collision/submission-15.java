class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (s.size() == 0) {
                s.push(asteroids[i]);
                continue;
            }
            
            int prev = s.peek();
            boolean pushOrNot = true;
            while (s.size() > 0 && prev > 0 && asteroids[i] < 0) {
                if (Math.abs(prev) == Math.abs(asteroids[i])) {
                    pushOrNot = false;
                    s.pop();
                    System.out.println("both explode");
                    break;
                }
                else if (Math.abs(prev) < Math.abs(asteroids[i])) {
                    s.pop();
                    if (s.size() != 0) prev = s.peek();
                }
                else {
                    pushOrNot = false;
                    break;
                }
            }
            if (pushOrNot) s.push(asteroids[i]); 
        }   

        int[] sol = new int[s.size()];
        int size = s.size();
        for (int i = 0; i < size; i++) {
            System.out.println(s.peek());
            int added = s.pop();
            sol[size - i - 1] = added;
        }

        return sol;

    }
}