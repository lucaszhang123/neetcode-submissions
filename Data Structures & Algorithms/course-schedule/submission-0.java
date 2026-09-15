class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> inwards = new HashMap<>();
        Map<Integer, Set<Integer>> outwards = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            inwards.put(i, new HashSet<Integer>());
            outwards.put(i, new HashSet<Integer>()); 
        }
        for (int[] preq : prerequisites) {
            inwards.get(preq[1]).add(preq[0]);   
            outwards.get(preq[0]).add(preq[1]); 
        }

        Queue<Integer> zeroInwards = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            Set<Integer> retrieved = inwards.get(i);
            if (retrieved.size() == 0) zeroInwards.add(i);
        }

        int numSuccess = 0;

        while (zeroInwards.size() != 0) {
            int retreived = zeroInwards.poll();
            numSuccess++;
            Set<Integer> adj = outwards.get(retreived);

            for (int i : adj) {
                Set<Integer> reqs = inwards.get(i);
                reqs.remove(retreived);

                if (reqs.size() == 0) {
                    zeroInwards.offer(i);
                }
            }
        }

        if (numSuccess == numCourses) return true;
        return false;
    }
}