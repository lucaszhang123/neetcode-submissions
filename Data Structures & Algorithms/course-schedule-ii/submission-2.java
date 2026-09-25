class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];

        int[] inDeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            List<Integer> start = new ArrayList<>();
            adj[i] = start;
        }

        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDeg[p[0]]++;
        }

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) q.offer(i);
            // System.out.println(i + " in degree: " + inDeg[i]);
        }

        // for (int i = 0; i < numCourses; i++) {
        //     for (int o : adj[i]) {
        //         System.out.print(o + " ");
        //     }
        //     System.out.println();
        // }

        int counter = 0;
        int[] sol = new int[numCourses];

        while (q.size() != 0) {
            int i = q.poll();

            //System.out.println("Put: " + i);
            sol[counter] = i;
            counter++;

            for (int n : adj[i]) {
                //System.out.print("Neighbor: " + n);
                inDeg[n]--;
                //System.out.println("; In degree: " + inDeg[n]);
                if (inDeg[n] == 0) q.offer(n);
            }
        }

        if (counter != numCourses) return new int[0];

        return sol;


        /*
        preq [1, 0]
        0 -> 1
        indeg 1++;
        */
    }
}
