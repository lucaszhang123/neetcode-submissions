class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]);

        for (int[] p : points) {
            if (pq.size() < k) pq.offer(p);
            else {
                int[] curMax = pq.peek();

                if (p[0]*p[0] + p[1]*p[1] < curMax[0]*curMax[0] + curMax[1]*curMax[1]) {
                    pq.poll();
                    pq.offer(p);
                }
            }
        }

        int[][] sol = new int[k][2];
        for (int i = 0; i < k; i++) {
            sol[i] = pq.poll();
        }
        
        return sol;
    }
}
